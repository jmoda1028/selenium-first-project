package academy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

public class GridTable extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void TableData() {

    }
}
