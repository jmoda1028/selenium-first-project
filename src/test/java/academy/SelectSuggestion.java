package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;
import java.util.function.Consumer;

public class SelectSuggestion extends base {

    private WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {

        driver = initializeDriver();

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void validateSelectSuggestionLabel()
    {

        HomePage h = new HomePage(driver);
        Assert.assertEquals(h.getSelectSuggestionLabel().getText(), "Suggession Class Example");
    }

    @Test
    public void suggestedCountry(){
        HomePage h = new HomePage(driver);
        h.getInputSelectSuggestion().click();
        h.getInputSelectSuggestion().sendKeys("phili");
        Assert.assertEquals(h.getSuggestedCountry().getText(), "Philippines");
        Actions act = new Actions(driver);
        act.moveToElement(h.getSuggestedCountry()).perform();
        String scCursor = h.getSuggestedCountry().getCssValue("cursor");
        Assert.assertEquals(scCursor, "pointer");
        h.getSuggestedCountry().click();

    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }

}
