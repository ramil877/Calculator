import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.time.Duration;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium CHROME DRIVER\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,1000);

        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        input.sendKeys("Калькулятор", Keys.ENTER);

        WebElement element1 = driver.findElement(By.xpath("//div[@jsname='N10B9']")); // 1
        WebElement element2 = driver.findElement(By.xpath("//div[@jsname='YovRWb']")); // *
        WebElement element3 = driver.findElement(By.xpath("//div[@jsname='lVjWed']")); // 2
        WebElement element4 = driver.findElement(By.xpath("//div[@jsname='pPHzQc']")); // -
        WebElement element5 = driver.findElement(By.xpath("//div[@jsname='KN1kY']")); // 3
        WebElement element6 = driver.findElement(By.xpath("//div[@jsname='XSr6wc']")); // +
        WebElement element7 = driver.findElement(By.xpath("//div[@jsname='N10B9']")); // 1
        WebElement element8 = driver.findElement(By.xpath("//div[@jsname='Pt8tGc']")); // =

        element1.click();
        element2.click();
        element3.click();
        element4.click();
        element5.click();
        element6.click();
        element7.click();
        element8.click();


        WebElement result1 = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span"));
        String text1 = result1.getText(); // 1 × 2 - 3 + 1 =

        WebElement result2 = driver.findElement(By.xpath("//*[@id='cwos']"));
        String text2 = result2.getText(); // 0

        Assert.assertEquals(text1, "1 × 2 - 3 + 1 =");
        Assert.assertEquals(text2, "0");


        Thread.sleep(2000);

        driver.quit();


    }
}
