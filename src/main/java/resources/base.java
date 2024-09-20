package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class base {

    public WebDriver driver;
    public Properties prop;

    public static ChromeOptions options;

    public WebDriver initializeDriver() throws IOException {
        prop= new Properties();
//        FileInputStream fis=new FileInputStream("C:\\Users\\Latifa\\IdeaProjects\\selenium-first-project\\src\\data.properties");

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName=prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("chrome"))
        {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
//
//            driver= new ChromeDriver();
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver(options);
            //execute in chrome driver
        }
        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            //firefox code
        }
        else if (browserName.equals("IE"))
        {
//	IE code
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
