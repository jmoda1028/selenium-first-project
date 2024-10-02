package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.base;

import java.io.IOException;
import java.util.List;

public class TableAmount extends base {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void ListAmountValues() {
        HomePage h = new HomePage(driver);

        List<WebElement> amounts = h.getTableProduct().findElements(By.xpath("//table[@id='product']//td[4]"));

        int count = amounts.size();

        for(int i=0; i<count-1; i++){

            if(amounts != null){

                //verify the list values of amount column
                String amount1 = amounts.get(0).getText();
                Assert.assertEquals(amount1, "28" );
                String amount2 = amounts.get(1).getText();
                Assert.assertEquals(amount2, "23" );
                String amount3 = amounts.get(2).getText();
                Assert.assertEquals(amount3, "48" );
                String amount4 = amounts.get(3).getText();
                Assert.assertEquals(amount4, "18" );
                String amount5 = amounts.get(4).getText();
                Assert.assertEquals(amount5, "32" );
                String amount6 = amounts.get(5).getText();
                Assert.assertEquals(amount6, "46" );
                String amount7 = amounts.get(6).getText();
                Assert.assertEquals(amount7, "37" );
                String amount8 = amounts.get(7).getText();
                Assert.assertEquals(amount8, "31" );
                String amount9 = amounts.get(8).getText();
                Assert.assertEquals(amount9, "33" );
            }
            return;
        }
    }

    @Test
    public void SumTotalAmounts(){

        HomePage h = new HomePage(driver);

        List<WebElement> amounts = h.getTableProduct().findElements(By.xpath("//table[@id='product']//td[4]"));

        int count = amounts.size();
        int totalAmount = 0;
        //sum up the total amount
        for(int i=0; i<count; i++){

            String value = h.getTableProduct().findElements(By.xpath("//table[@id='product']//td[4]")).get(i).getText();
            int valueInteger=  Integer.parseInt(value);
            totalAmount=totalAmount+valueInteger;
        }

//        System.out.println(sum);
        // verify the total of amount column
        String ActualTotal = driver.findElement(By.cssSelector("div[class='totalAmount']")).getText();
        String name = ActualTotal.replaceAll(".+:", "");
        String formattedName = name.trim();
        int actualTotalInteger=Integer.parseInt(formattedName);

        Assert.assertEquals(actualTotalInteger, totalAmount);

//        System.out.println("actual total " + formattedName);
//        System.out.println("expected total " + totalAmount);
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}
