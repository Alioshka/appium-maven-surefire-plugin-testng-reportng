package e2e;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationManager {

    public static final String DRIVER_TYPE = System.getProperties().getProperty("driver.type");

    public static final URL APPIUM_URL = getAppiumUrl();

    private static URL getAppiumUrl(){
        try {
            return new URL(System.getProperties().getProperty("appium.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException("MalformedURLException for appium url, can't create URL class obj from this string: "
                    + System.getProperties().getProperty("appium.url"));
        }
    }
}
