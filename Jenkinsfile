pipeline {
    agent {
        label 'Dominic-PC-D'
        retries 2
    }
    environment {
        MAVEN_CLEAN_COMPILE_COMMAND = "mvn clean compile"
        REPORT_DIR = "Reports"
        REPORT_FILE = "Spark.html"
        REPORT_NAME = "ExtentReport"
        TESTNG_NAME = "**/target/testng-results.xml"
    }

    stages {
        stage('Checkout'){
            steps{
                checkout scm
            }
        }
        stage('Build & Test') {
            parallel {
                stage('Build') {
                    steps {
                        bat "${MAVEN_CLEAN_COMPILE_COMMAND}"
                    }
                    post {
                        failure {
                            echo "Build failed. Please check the logs."
                        }
                    }
                }
                 stage('Transaction Test') {
                        steps {
                            bat "mvn clean test -DfileName=transactionals.xml"
                        }
                    }
                stage('Regression Test') {
                    steps {
                        bat "mvn clean test -DfileName=test.xml"
                    }
                    post {
                        success {
                            publishHTML([
                                allowMissing: false,
                                alwaysLinkToLastBuild: true,
                                keepAll: false,
                                reportDir: "${REPORT_DIR}",
                                reportFiles: "${REPORT_FILE}",
                                reportName: "${REPORT_NAME}",
                                reportTitles: '',
                                useWrapperFileDirectly: true
                            ])
                           testNG([
                                escapeExceptionMsg: true,
                                escapeTestDescp: true,
                                failedFails : 5,
                                thresholdMode : true,
                                reportFilenamePattern : "${TESTNG_NAME}"
                           ])
                            junit '**/target/surefire-reports/*.xml'
                        }
                        failure {
                            publishHTML([
                                allowMissing: false,
                                alwaysLinkToLastBuild: true,
                                keepAll: false,
                                reportDir: "${REPORT_DIR}",
                                reportFiles: "${REPORT_FILE}",
                                reportName: "${REPORT_NAME}",
                                reportTitles: '',
                                useWrapperFileDirectly: true
                            ])
                        }
                         testNG([
                            escapeExceptionMsg: true,
                            escapeTestDescp: true,
                            failedFails : 5,
                            thresholdMode : true,
                            reportFilenamePattern : "${TESTNG_NAME}"
                       ])
                        junit '**/target/surefire-reports/*.xml'
                    }
                }
            }
        }
       // sonar qube, dockerized, and deploy
    }
}