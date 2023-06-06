package ZipCodeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeShouldNotAccept6Digits {

    @Test(description = "NegativTest" + " чтобы не забыть, а как я должен прописать негативный тест???" +
            "а как все запустить из 1 класса, у меня ведь не объектов класса" +
            "а зачем использовать русский язык?, т.к для машины это то же самое что и английский" +
            "система ругается на названия, в чем косяк?:)" +
            "куда писать git rm или git log, их аналоги я то нашел, н.о...")
    public void zipCodeShouldNotAccept6Digits(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }

}
