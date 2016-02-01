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
        driver = DriverManager.getDriver();
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test(String baseUrl) {
        driver.get(baseUrl);
        Assert.assertEquals(driver.getTitle(), "BBC - Homepage");
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test2(String baseUrl) {
        driver.get(baseUrl + "sport/");
        Assert.assertEquals(driver.getTitle(), "BBC Sport - Sport");
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test3(String baseUrl) {
        driver.get(baseUrl + "weather/");
        Assert.assertEquals(driver.getTitle(), "BBC Weather");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
