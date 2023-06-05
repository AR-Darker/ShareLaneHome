package ZipCodeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeShouldNotAcceptImpossible {

        @Test(description = "NegativTest" + "ввожу 99999.....9999999999999999999 это нереальное значение")
        public void zipCodeShouldNotImpossible(){

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.sharelane.com/cgi-bin/register.py");

            WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
            zipCodeInput.sendKeys("9999999999999999999999999999999999999999999999999999999999999" +
                    "9999999999" +
                    "99999999999999999999999999999999999999999999999999999999999999999" +
                    "99999999999999999999999999999999999999999999999999999999999" +
                    "9999999999999999999999999999999999999999999999999999999999999" +
                    "99999999999999999999999999999999999999999999999999999999999999999" +
                    "9999999999999999999999999999999999999999999999999999999999999999" +
                    "999999999999999999999999999999999999999999999999999999999999999" +
                    "99999999999999999999999999999999999999999999999999999999999999" +
                    "999999999999999999999999999999999999999999999999999999999999");

            WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
            continueButton.click();

            String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

            Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                    "ErrorMessage is notcorrect or system accepted data");

            driver.quit();
        }

    }
