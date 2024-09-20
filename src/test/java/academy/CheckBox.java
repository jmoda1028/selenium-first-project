package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class CheckBox extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    @Test
    public void validateCheckBoxLabel() {

        HomePage h = new HomePage(driver);

        h.getCheckBoxLabel().isDisplayed();
        Assert.assertEquals(h.getCheckBoxLabel().getText(), "Checkbox Example");
    }

    @Test
    public void validateOptionsLabel() {

        HomePage h = new HomePage(driver);
        Actions act = new Actions(driver);

        // validate the options label and text contains
        h.getOption1Label().isDisplayed();
        Assert.assertEquals(h.getOption1Label().getText(), "Option1");
        h.getOption2Label().isDisplayed();
        Assert.assertEquals(h.getOption2Label().getText(), "Option2");
        h.getOption3Label().isDisplayed();
        Assert.assertEquals(h.getOption3Label().getText(), "Option3");

        // validate the options cursor
        act.moveToElement(h.getOption1Label()).perform();
        String ol1 = h.getOption1Label().getCssValue("cursor");
        Assert.assertEquals(ol1, "pointer");

        act.moveToElement(h.getOption2Label()).perform();
        String ol2 = h.getOption2Label().getCssValue("cursor");
        Assert.assertEquals(ol2, "pointer");

        act.moveToElement(h.getOption3Label()).perform();
        String ol3 = h.getOption3Label().getCssValue("cursor");
        Assert.assertEquals(ol3, "pointer");
    }

    @Test
    public void checkBoxSelection()
    {

        HomePage h = new HomePage(driver);

        //get the value of attribute value
        String cbv1 = h.getCheckBox1().getAttribute("value");
        Assert.assertEquals(cbv1, "option1");

        String cbv2 = h.getCheckBox2().getAttribute("value");
        Assert.assertEquals(cbv2, "option2");

        String cbv3 = h.getCheckBox3().getAttribute("value");
        Assert.assertEquals(cbv3, "option3");

        h.getCheckBox1().click();
        h.getCheckBox1().isSelected();

        h.getCheckBox2().click();
        h.getCheckBox2().isSelected();

        h.getCheckBox3().click();
        h.getCheckBox3().isSelected();
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
