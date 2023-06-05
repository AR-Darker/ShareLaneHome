package ZipCodeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeShouldAccept5Digits {
    @Test(description = "ввожу 12345")
    public void zipCodeShouldAccept5Digits(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        WebElement FirstNameChecking = driver.findElement(By.name("first_name"));

        boolean isDisplayed = FirstNameChecking.isDisplayed();
        Assert.assertTrue(isDisplayed, "На страницу SignUp не перешли");

        driver.quit();
    }
}


