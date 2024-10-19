package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;

public class AlertButton extends base {

    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void validateAlertMessageButton() {

        HomePage h = new HomePage(driver);

        h.getAlertInputBox().click();
        h.getAlertInputBox().sendKeys("Junaid");
        h.getBtnAlert().click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Hello Junaid, share this practice page and share your knowledge" );
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        //confirm alert, clicking cancel
        h.getAlertInputBox().click();
        h.getAlertInputBox().sendKeys("Moda");
        h.getConfirmAlert().click();
        String confirmText = driver.switchTo().alert().getText();
        Assert.assertEquals(confirmText, "Hello Moda, Are you sure you want to confirm?" );
        System.out.println(confirmText);
        driver.switchTo().alert().dismiss();

        //confirm alert, clicking ok
        h.getAlertInputBox().click();
        h.getAlertInputBox().sendKeys("Hisoka");
        h.getConfirmAlert().click();
        String confirmText2 = driver.switchTo().alert().getText();
        Assert.assertEquals(confirmText2, "Hello Hisoka, Are you sure you want to confirm?" );
        System.out.println(confirmText2);
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}
