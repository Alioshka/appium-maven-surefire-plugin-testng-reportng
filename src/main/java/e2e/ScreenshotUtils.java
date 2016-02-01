package e2e;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private static final String TEST_OUTPUT = "target/test-output/html/";

    private static final String SCREENSHOTS_FOLDER = "screenshots/";

    public static String takeScreenshot() {
        File tempFile;
        tempFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String file = timeStamp + ".png";
        try {
            FileUtils.copyFile(tempFile, new File(TEST_OUTPUT + SCREENSHOTS_FOLDER + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SCREENSHOTS_FOLDER + file;
    }
}