package e2e;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AndroidNativeTests {

    MobileDriver driver;

    @BeforeClass
    public void setup(){
        driver = DriverManager.getDriver();
    }

    @Test(enabled = true)
    public void contactManagerTest() {
        driver.findElement(By.id("Add Contact")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("Appium User");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("4444");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("appium@user.com");
    }

    @AfterClass
    public void teardown(){
        driver.closeApp();
    }

}
