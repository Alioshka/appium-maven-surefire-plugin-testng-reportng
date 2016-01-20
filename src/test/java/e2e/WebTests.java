package e2e;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTests {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = DriverManager.getWebDriver();
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test(String baseUrl) {
        driver.get(baseUrl);
        Assert.assertEquals(driver.getTitle(), "BBC - Homepage");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
