package ZipCodeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeShouldNotAcceptFloat {
    @Test(description = "NegativTest")
    public void zipCodeShouldNotAcceptFloat(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12.345");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }

}



