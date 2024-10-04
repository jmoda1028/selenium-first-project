package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class SwitchWindow extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

//    @Test
//    public void validateSwitchWindowLabel() {
//
//        HomePage h = new HomePage(driver);
//
//        h.getSwitchWindowLabel().isDisplayed();
//        Assert.assertEquals(h.getSwitchWindowLabel().getText(), "Switch Window Example");
//    }

    @Test
    public void validateSwitchWindowButton() {

        HomePage h = new HomePage(driver);

        h.getSwitchWindowBtn().click();
        Object[] windowHandles=driver.getWindowHandles().toArray();
        //switch to child window
        driver.switchTo().window((String) windowHandles[1]);
        //assert on title of new window
        String nwUrl = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl, "https://www.qaclickacademy.com/" );
        System.out.println(nwUrl);
        driver.close();

        //switch back to parent window
        driver.switchTo().window((String) windowHandles[0]);
        String nwUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl2, "https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(nwUrl2);
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
