package e2e;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static DriverManager instance;

    private WebDriver webDriver;

    private MobileDriver mobileDriver;

    private DriverManager() {
        createDriver(ConfigurationManager.DRIVER_TYPE);
    }

    private static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private synchronized void createDriver(String driverType) {
        DesiredCapabilities capabilities;
        switch (driverType) {
            case "Chrome":
                setChromeSystemProperty();
                setWebDriver(new ChromeDriver());
                break;
            case "Firefox":
                setWebDriver(new FirefoxDriver());
                break;
            case "Safari":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            case "AndroidChrome":
                capabilities = new CapabilitiesLoader("Android_Chrome_Capabilities.properties").loadCapabilities();
                setWebDriver(new RemoteWebDriver(ConfigurationManager.APPIUM_URL, capabilities));
                break;
            case "iOSSafari":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            case "Android":
                capabilities = new CapabilitiesLoader("Android_Capabilities.properties").loadCapabilities();
                setMobileDriver(new AndroidDriver(ConfigurationManager.APPIUM_URL, capabilities));
                break;
            case "iOS":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            default:
                throw new UnsupportedOperationException(
                        "unknown driver type !!! please, check your command line parameter: -DdriverTyp");
        }
    }

    public void setChromeSystemProperty() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            os = "windows";
        }
        if (os.contains("mac")) {
            os = "mac";
        }
        if (os.contains("linux")) {
            os = "linux";
        }
        switch (os) {
            case "windows":
                System.setProperty("webdriver.chrome.driver", "drivers/windows/chromedriver.exe");
                break;
            case "mac":
                System.setProperty("webdriver.chrome.driver", "drivers/mac/chromedriver");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver", "drivers/linux32/chromedriver");
                break;
            default:
                System.out.println("Unknown OS: " + os);
                break;
        }
    }

    public static WebDriver getWebDriver() {
        return getInstance().webDriver;
    }

    private void setWebDriver(WebDriver driver) {
        webDriver = driver;
    }

    public static MobileDriver getMobileDriver() {
        return getInstance().mobileDriver;
    }

    private void setMobileDriver(MobileDriver driver) {
        mobileDriver = driver;
    }
}
