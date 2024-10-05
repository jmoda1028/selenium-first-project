package academy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;
import java.io.File;
import java.io.IOException;

public class screenShot extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void Screenshots() throws IOException{

        HomePage h = new HomePage(driver);

        String pt = h.getTitle().getText();
//        System.out.println(pt);
//        Assert.assertEquals(pt, "why we are Leaders in market?!");
        h.getBtnDropdown().click();

        // screenshot the whole page
        File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\src\\main\\resources\\screenshots\\screenshot.png"));

        h.getInputSelectSuggestion().click();
        h.getInputSelectSuggestion().sendKeys("jap");
        Assert.assertEquals(h.getSuggestedCountry().getText(), "Japan");

        // screenshot a specific element
        File file=h.getInputSelectSuggestion().getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\src\\main\\resources\\screenshots\\element-screenshot.png"));
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
