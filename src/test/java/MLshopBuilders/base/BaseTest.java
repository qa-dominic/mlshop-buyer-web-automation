package MLshopBuilders.base;

import mlshopbuilder.testSteps.*;
import org.testng.annotations.*;
import static utilities.Driver.DriverManager.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import utilities.Driver.DriverType;
import utilities.Logger.LoggingUtils;

public class BaseTest {

    protected Login_Steps loginSteps;
    protected Home_Steps homeSteps;
    protected Shipping_Steps shippingSteps;
    protected Cart_Steps cartSteps;

    private static final int PAGE_LOAD_TIMEOUT = 30;
    private static final int IMPLICIT_WAIT = 10;

    @Parameters("browser")
    @BeforeClass (alwaysRun = true)
    public void setUp(final String browser) throws InterruptedException {
        validateBrowser(browser);
        initializeDriver(browser);
        configureDriver();
        navigateToTargetUrl();
        initSteps();
    }
    
    private void validateBrowser(String browser) {
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser parameter cannot be null or empty");
        }
        LoggingUtils.info("Base test browser type: " + browser.toUpperCase());
    }

    private void initializeDriver(String browser) {
        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote"));
        DriverType driverType;
        if(isRemote){
            driverType = DriverType.valueOf("REMOTE_CHROME");
        }else{
            driverType = DriverType.valueOf(browser.toUpperCase());
        }
        createDriver(driverType);
    }

     private void configureDriver() {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
    }

    private void navigateToTargetUrl() {
        String targetUrl = System.getProperty("targetUrl");
        if (targetUrl == null || targetUrl.isEmpty()) {
            throw new IllegalStateException("Target URL is not set. Please set the 'targetUrl' system property.");
        }
        getDriver().get(targetUrl);
        LoggingUtils.info("Navigated to target URL: " + targetUrl);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTests(){
        getDriver().get(System.getProperty("targetUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void clean(){
        getDriver().manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown () {
        closeWebBrowser();
    }

    private void initSteps(){
        loginSteps = new Login_Steps();
        homeSteps = new Home_Steps();
        shippingSteps = new Shipping_Steps();
        cartSteps = new Cart_Steps();
    }
}