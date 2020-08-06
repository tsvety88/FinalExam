import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountRegistration {


    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg/index.php?route=common/home");

    }

    @Test
    public void successfullRegCreation() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Tsvetomira");
        driver.findElement(By.id("input-lastname")).sendKeys("Madzharova");

        String randomEmail = RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
        driver.findElement(By.id("input-email")).sendKeys(randomEmail);

        driver.findElement(By.id("input-telephone")).sendKeys("0888888888");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.id("input-confirm")).sendKeys("parola123!");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        if (!checkBox.isSelected())
            checkBox.click();
        assertTrue(checkBox.isSelected());

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a")).click();


    }




    @AfterMethod
    public void tearDown() {
     //   driver.quit();
    }
}
