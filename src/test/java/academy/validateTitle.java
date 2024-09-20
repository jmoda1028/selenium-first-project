package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

public class validateTitle extends base {
    public WebDriver driver;

    @BeforeTest
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
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
