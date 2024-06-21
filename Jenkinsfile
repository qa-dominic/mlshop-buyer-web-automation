pipeline {
    agent {
        label 'Dominic-PC-D'
    }
    environment {
        MAVEN_CMD = "mvn clean compile"
        REPORT_DIR = "Reports"
        REPORT_FILE = "Spark.html"
        REPORT_NAME = "ExtentReport"
    }

    stages {
        stage('Build & Test') {
            parallel {
                stage('Build') {
                    steps {
                        bat "${MAVEN_CMD}"
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
                stage('Test') {
                    steps {
                        bat "mvn clean test -DfileName=test.xml"
                    }
                    post {
                        success {
                            publishHTML([
                                allowMissing: false,
                                alwaysLinkToLastBuild: false,
                                keepAll: false,
                                reportDir: "${REPORT_DIR}",
                                reportFiles: "${REPORT_FILE}",
                                reportName: "${REPORT_NAME}",
                                reportTitles: '',
                                useWrapperFileDirectly: true
                            ])
                        }
                        failure {
                            publishHTML([
                                allowMissing: false,
                                alwaysLinkToLastBuild: false,
                                keepAll: false,
                                reportDir: "${REPORT_DIR}",
                                reportFiles: "${REPORT_FILE}",
                                reportName: "${REPORT_NAME}",
                                reportTitles: '',
                                useWrapperFileDirectly: true
                            ])
                        }
                    }
                }
            }
        }
    }
}