package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridTable extends base {

    public WebDriver driver;

    @BeforeClass
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void TableData() {

        HomePage h = new HomePage(driver);

//        int countCourses = h.getTableProduct().findElements(By.xpath("(//table[@id='product'])[1]//td[2]")).size();

        List<WebElement> courseList = h.getTableProduct().findElements(By.xpath("(//table[@id='product'])[1]//td[2]"));

        // Extract text from each element into a list
        List<String> courseColumnTexts = new ArrayList<>();
        for (WebElement course : courseList) {
            courseColumnTexts.add(course.getText());

        }

        // Expected list of texts
        List<String> expectedCourseColumnTexts = new ArrayList<>();

        expectedCourseColumnTexts.add("Selenium Webdriver with Java Basics + Advanced + Interview Guide");
//        System.out.println(expectedCourseColumnTexts.get(0));
        expectedCourseColumnTexts.add("Learn SQL in Practical + Database Testing from Scratch");
//        System.out.println(expectedCourseColumnTexts.get(1));
        expectedCourseColumnTexts.add("Appium (Selenium) - Mobile Automation Testing from Scratch");
        expectedCourseColumnTexts.add("WebSecurity Testing for Beginners-QA knowledge to next level");
        expectedCourseColumnTexts.add("Learn JMETER from Scratch - (Performance + Load) Testing Tool");
        expectedCourseColumnTexts.add("WebServices / REST API Testing with SoapUI");
        expectedCourseColumnTexts.add("QA Expert Course :Software Testing + Bugzilla + SQL + Agile");
        expectedCourseColumnTexts.add("Master Selenium Automation in simple Python Language");
        expectedCourseColumnTexts.add("Advanced Selenium Framework Pageobject, TestNG, Maven, Jenkins,C");
        expectedCourseColumnTexts.add("Write effective QA Resume that will turn to interview call");

        // Assert that the actual list matches the expected list
        Assert.assertEquals(courseColumnTexts, expectedCourseColumnTexts, "The list of texts does not match the expected values.");
    }
    @AfterClass
    public void teardown() {
        driver.close();
    }
}
