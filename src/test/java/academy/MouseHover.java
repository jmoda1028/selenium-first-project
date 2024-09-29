package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class MouseHover extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void MouseHover(){

        HomePage h = new HomePage(driver);
        Actions action = new Actions(driver);

        action.moveToElement(h.getBtnMouseHover()).perform();
        h.getPanelMouseHover().isDisplayed();
        action.moveToElement(h.getBtnAnchorChild1()).perform();
        h.getBtnAnchorChild1().click();
        action.moveToElement(h.getBtnMouseHover()).perform();
        action.moveToElement(h.getBtnAnchorChild2()).perform();
        h.getBtnAnchorChild2().click();
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
