package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class iFrame extends base {

    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    @Test
    public void iFrame() {

        HomePage h = new HomePage(driver);

        //iframe
        driver.switchTo().frame(h.getIframeCourses());
        String priceTitle = h.getPriceTitle().getText();
        Assert.assertEquals(priceTitle, "why we are Leaders in market?!");
//        System.out.println(priceTitle);

        // back to default html elements
        driver.switchTo().defaultContent();
        String pageTitle = h.getTitle().getText();
        Assert.assertEquals(pageTitle, "Practice Page");
//        System.out.println(pageTitle);
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}
