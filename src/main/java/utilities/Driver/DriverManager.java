package utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.Logger.LoggingUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final String SELENIUM_GRID_URL_PROPERTY = "gridURL";
    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    private static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(20);
    private static final Duration SCRIPT_TIMEOUT = Duration.ofSeconds(10);

    private DriverManager(){}

    public static void createDriver(final DriverType browser){
        switch (browser){
            case CHROME:
                setupChrome();
                break;
            case REMOTE_CHROME:
                setupRemoteChrome();
                break;
            default:
                LoggingUtils.error("Invalid Browser...");
                break;
        }
        setupBrowserTimeouts();
    }
    // public static void setupChrome(){
    //     try{
    //         LoggingUtils.info("Setting up chrome driver...");
    //         HashMap<String, Object> chromePreferences = new HashMap<>();
    //         final ChromeOptions options = getChromeOptions();
    //         options.setExperimentalOption("prefs", chromePreferences);
    //         DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    //         desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options); 
    //         WebDriverManager.chromedriver().clearDriverCache().capabilities(desiredCapabilities).setup();
    //         setDriver(new ChromeDriver(options));
    //         LoggingUtils.info("Chrome Driver created successfully");
    //     }catch (Exception e){
    //         LoggingUtils.error("Error setting up remote Chrome." + e);
    //     }
    // }
    private static void setupChrome() {
        LoggingUtils.info("Setting up chrome driver...");
        try {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            setDriver(new ChromeDriver(getChromeOptions()));
            LoggingUtils.info("Chrome Driver created successfully");
        } catch (Exception e) {
            LoggingUtils.error("Error setting up Chrome: " + e.getMessage());
            throw new RuntimeException("Failed to set up Chrome driver", e);
        }
    }

    // public static void setupRemoteChrome(){
    //     try {
    //         LoggingUtils.info ("Setting up Remote Chrome Driver....");
    //         final ChromeOptions options = getChromeOptions();
    //         final String seleniumGridUrl = System.getProperty("gridURL");
    //         if (seleniumGridUrl == null || seleniumGridUrl.trim().isEmpty()) {
    //             throw new IllegalStateException("Selenium Grid URL is not set. Please set the 'seleniumGridURL' system property.");
    //         }
    //         setDriver(new RemoteWebDriver(new URL(seleniumGridUrl), options));
    //         LoggingUtils.info("Remote Chrome Driver created successfully!");
    //         } catch (MalformedURLException | IllegalStateException e) {
    //             LoggingUtils.error("Error setting up remote Chrome." + e);
    //         }
    // }
    private static void setupRemoteChrome() {
        LoggingUtils.info("Setting up Remote Chrome Driver...");
        try {
            String seleniumGridUrl = System.getProperty(SELENIUM_GRID_URL_PROPERTY);
            if (seleniumGridUrl == null || seleniumGridUrl.trim().isEmpty()) {
                throw new IllegalStateException("Selenium Grid URL is not set. Please set the '" + SELENIUM_GRID_URL_PROPERTY + "' system property.");
            }
            setDriver(new RemoteWebDriver(new URL(seleniumGridUrl), getChromeOptions()));
            LoggingUtils.info("Remote Chrome Driver created successfully!");
        } catch (MalformedURLException e) {
            LoggingUtils.error("Error setting up remote Chrome: " + e.getMessage());
            throw new RuntimeException("Failed to set up remote Chrome driver", e);
        }
    }
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "enable-automation",
            "--no-sandbox",
            "--disable-extensions",
            "--disable-infobars",
            "--disable-dev-shm-usage",
            "--disable-browser-side-navigation",
            "--disable-gpu",
            "--start-maximized",
            "--ignore-certificate-errors",
            "--disable-notifications",
            "--incognito",
            "use-fake-ui-for-media-stream"
        );
        return options;
    }

    //method for quitting driver
    public static void closeWebBrowser() {
        WebDriver driver = getDriver();
        if (driver != null) {
            String currentWindowHandle = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(currentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    LoggingUtils.info("Switch to window " + windowHandle);
                    driver.close();
                    LoggingUtils.info("Driver closed");
                }
            }
            driver.switchTo().window(currentWindowHandle);
            driver.quit();
            LoggingUtils.info("All windows closed and driver quit");
        }
}

   
    private static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    //method for getting driver
    public static WebDriver getDriver () {
        return DRIVER.get ();
    }

    //setup for timeouts
     private static void setupBrowserTimeouts() {
        LoggingUtils.info("Setting browser timeouts...");
        WebDriver driver = getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT);
        driver.manage().timeouts().scriptTimeout(SCRIPT_TIMEOUT);
    }

    
}
