package ZipCodeTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UltraTest {

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

@Test
public void zipCodeShouldNotAccept4Digits(){

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.sharelane.com/cgi-bin/register.py");

    WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("1234");

    WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

    Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}

    @Test(description = "NegativTest")
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

    @Test(description = "NegativTest")
public void zipCodeShouldNotAcceptAnyLetters() {

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.sharelane.com/cgi-bin/register.py");

    WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("abcde");

    WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

    Assert.assertEquals(errorMessageForEquals, "Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}
    @Test(description = "NegativTest")
    public void zipCodeShouldNotAcceptEmptyField(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("");

        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }

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

    public class ZipCodeShouldNotAcceptNegativ5Digits {
        @Test(description = "NegativTest" + "Это ведь 6 символов тоже, но по тест-дизайну так надо")
        public void zipCodeShouldNotAcceptNegativ5Digits(){

            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.sharelane.com/cgi-bin/register.py");

            WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
            zipCodeInput.sendKeys("-12345");

            WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
            continueButton.click();

            String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

            Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                    "ErrorMessage is notcorrect or system accepted data");

            driver.quit();
        }

    }    public void zipCodeShouldNotAcceptSpecSymbols(){

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.sharelane.com/cgi-bin/register.py");

    WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("!@#$%");

    WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector("[class='error_message']")).getText();

    Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}

}

