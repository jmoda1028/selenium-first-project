package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;
import java.util.ArrayList;

public class SwitchTab extends base {

    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    @Test
    public void validateSwitchWindowButton() {

        HomePage h = new HomePage(driver);

        h.getSwitchTabBtn().click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String nwUrl = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl, "https://www.qaclickacademy.com/" );
        System.out.println(nwUrl);
//        driver.close();
        driver.switchTo().window(tabs.get(0));
        String nwUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl2, "https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(nwUrl2);

        //switch to new tab and then close it
        driver.switchTo().window(tabs.get(1));
        driver.close();

        //active the old tab
        driver.switchTo().window(tabs.get(0));
        String nwUrl3 = driver.getCurrentUrl();
        Assert.assertEquals(nwUrl3, "https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(nwUrl3);
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}


