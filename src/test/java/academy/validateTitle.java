package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

public class validateTitle extends base {

    public static Logger log = LogManager.getLogger(validateTitle.class.getName());
    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException
    {

        driver = initializeDriver();

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void validatePageTitle()
    {

        HomePage h = new HomePage(driver);
        //compare the text from the browser with actual text.- Error..

        Assert.assertEquals(h.getTitle().getText(), "Practice Page");
        log.info("title matched");
    }

    @AfterClass
    public void teardown()
    {
        driver.close();
    }
}
