package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class HideShow extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void HideShow(){

        HomePage h = new HomePage(driver);

        h.getBtnHide().click();
        String inputHide = h.getInputBoxShowHide().getCssValue("display");
        Assert.assertEquals(inputHide, "none");
        h.getBtnShow().click();
        String inputShow = h.getInputBoxShowHide().getCssValue("display");
//        System.out.println(inputShow);
        Assert.assertEquals(inputShow, "block");
    }
}
