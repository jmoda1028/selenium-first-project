package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class RadioButtons extends base {

    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException
    {

        driver = initializeDriver();

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void validateRadioButtonsLabel(){

        HomePage h = new HomePage(driver);

        Assert.assertEquals(h.getRadioBtnLabel().getText(), "Radio Button Example");
    }

    @Test
    public void validateRadioButtons()
    {

        HomePage h = new HomePage(driver);

        h.getRadioBtn1().click();
        h.getRadioBtn2().click();
        h.getRadioBtn3().click();
    }

    @AfterClass
    public void teardown()
    {
        driver.close();
    }

}
