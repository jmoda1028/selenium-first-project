package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class HideShow extends base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(HideShow.class.getName());

    @BeforeClass
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
        log.info("css value matched");
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}
