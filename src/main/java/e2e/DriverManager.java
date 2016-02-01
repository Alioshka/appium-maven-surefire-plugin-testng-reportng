package e2e;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager<T> {

    private static ThreadLocal<DriverManager> instance = new ThreadLocal<>();

    private T driver;

    private DriverManager() {
        createDriver(ConfigurationManager.DRIVER_TYPE);
    }

    private static synchronized DriverManager getInstance() {
        if (instance.get() == null) {
            instance.set(new DriverManager());
        }
        return instance.get();
    }

    @SuppressWarnings("unchecked")
    private void createDriver(String driverType){
        DesiredCapabilities capabilities;
        switch (driverType) {
            case "Chrome":
                setChromeSystemProperty();
                setDriver((T) new ChromeDriver());
                break;
            case "Firefox":
                setDriver((T) new FirefoxDriver());
                break;
            case "Safari":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            case "AndroidChrome":
                capabilities = new CapabilitiesLoader("Android_Chrome_Capabilities.properties").loadCapabilities();
                setDriver((T) new RemoteWebDriver(ConfigurationManager.APPIUM_URL, capabilities));
                break;
            case "iOSSafari":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            case "Android":
                capabilities = new CapabilitiesLoader("Android_Capabilities.properties").loadCapabilities();
                setDriver((T) new AndroidDriver(ConfigurationManager.APPIUM_URL, capabilities));
                break;
            case "iOS":
                throw new UnsupportedOperationException(
                        "not implemented yet !!!");
            default:
                throw new UnsupportedOperationException(
                        "unknown driver type !!! please, check your command line parameter: -DdriverTyp");
        }
    }

    private void setChromeSystemProperty() {
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

    @SuppressWarnings("unchecked")
    public static <T> T getDriver() {
        return (T) getInstance().driver;
    }

    private void setDriver(T driver) {
        this.driver = driver;
    }
}
