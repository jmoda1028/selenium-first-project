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
import java.time.Duration;

public class DropdownMenu extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void validateDropdownLabel() {

        HomePage h = new HomePage(driver);

//        Assert.assertEquals(h.getDropDownLabel().getText(), "Dropdown Example");
        h.getDropDownLabel().isDisplayed();
    }

    @Test
    public void validateDropdownButtons() {

        HomePage h = new HomePage(driver);
        Actions act = new Actions(driver);

        h.getBtnDropdown().click();
//        act.moveToElement(h.getDropdownOption1()).perform();
//        act.moveToElement(h.getDropdownOption1()).build().perform();
        h.getDropdownOption1().click();
        h.getBtnDropdown().click();
//        act.moveToElement(h.getDropdownOption2()).perform();
        h.getDropdownOption2().click();
        h.getBtnDropdown().click();
//        act.moveToElement(h.getDropdownOption3()).perform();
        h.getDropdownOption3().click();
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
