package e2e;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTests2 {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = DriverManager.getDriver();
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test(String baseUrl) {
        driver.get(baseUrl);
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test2(String baseUrl) {
        driver.get(baseUrl + "careers");
        Assert.assertEquals(driver.getTitle(), "Careers");
    }

    @Parameters({ "baseUrl" })
    @Test()
    public void test3(String baseUrl) {
        driver.get(baseUrl + "about");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
