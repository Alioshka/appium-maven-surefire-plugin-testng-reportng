package e2e;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Map;

public class CapabilitiesLoader {

    private static final String CONFIG_PATH = "resources/capabilities/";

    private String configName;

    public CapabilitiesLoader(String config) {
        this.configName = config;
    }

    public DesiredCapabilities loadCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> capabilitiesMap = PropertyReader.getPropertiesMap(new File(CONFIG_PATH + configName));

        for (Map.Entry<String, String> entry : capabilitiesMap.entrySet()) {
            if (entry.getKey().equals("app")){
                capabilities.setCapability(entry.getKey(),new File(entry.getValue()).getAbsolutePath());
            }else{
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }

        }

        return capabilities;
    }
}

