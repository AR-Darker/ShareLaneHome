import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodePageTesting extends BaseTest {
    String ZipCodeLocator = "zip_code";
    String ContinueButtonLocator = "[value=Continue]";
    String ErrorMessageLocator = "[class='error_message']";

    @Test(description = "ввожу 12345")
    public void zipCodeShouldAccept5Digits(){



        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
        continueButton.click();

        WebElement FirstNameChecking = driver.findElement(By.name("first_name"));

        boolean isDisplayed = FirstNameChecking.isDisplayed();
        Assert.assertTrue(isDisplayed, "На страницу SignUp не перешли");

        driver.quit();
    }

@Test
public void zipCodeShouldNotAccept4Digits(){



    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);

    WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
    zipCodeInput.sendKeys("1234");

    WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

    Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}

    @Test(description = "NegativTest")
public void zipCodeShouldNotAccept6Digits(){



    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);

    WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
    zipCodeInput.sendKeys("123456");

    WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

    Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}

    @Test(description = "NegativTest")
public void zipCodeShouldNotAcceptAnyLetters() {



    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);

    WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
    zipCodeInput.sendKeys("abcde");

    WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

    Assert.assertEquals(errorMessageForEquals, "Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}
    @Test(description = "NegativTest")
    public void zipCodeShouldNotAcceptEmptyField(){



        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
        zipCodeInput.sendKeys("");

        WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }

    @Test(description = "NegativTest")
    public void zipCodeShouldNotAcceptFloat(){



        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
        zipCodeInput.sendKeys("12.345");

        WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }

    @Test(description = "NegativTest" + "ввожу 99999.....9999999999999999999 это нереальное значение" +
            "почему не запускаются нижние классы")
    public void zipCodeShouldNotImpossible(){



        WebDriver driver = new ChromeDriver();
        driver.get(BASE_URL);

        WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
        zipCodeInput.sendKeys("9999999999999999999999999999999999999999999999999999999999999" +
                "9999999999" +
                "99999999999999999999999999999999999999999999999999999999999999999" +
                "99999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999" +
                "99999999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999999" +
                "999999999999999999999999999999999999999999999999999999999999999" +
                "99999999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999" +
                "9999999999999999999999999999999999999999999999999999999999999");

        WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
        continueButton.click();

        String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                "ErrorMessage is notcorrect or system accepted data");

        driver.quit();
    }
     @Test(description = "NegativTest" + "Это ведь 6 символов тоже, но по тест-дизайну так надо")
        public void zipCodeShouldNotAcceptNegativ5Digits(){



            WebDriver driver = new ChromeDriver();
            driver.get(BASE_URL);

            WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
            zipCodeInput.sendKeys("-12345");

            WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
            continueButton.click();

            String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

            Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
                    "ErrorMessage is notcorrect or system accepted data");

            driver.quit();


    }
    @Test
    public void zipCodeShouldNotAcceptSpecSymbols(){



    WebDriver driver = new ChromeDriver();
    driver.get(BASE_URL);

    WebElement zipCodeInput = driver.findElement(By.name(ZipCodeLocator));
    zipCodeInput.sendKeys("!@#$%");

    WebElement continueButton = driver.findElement(By.cssSelector(ContinueButtonLocator));
    continueButton.click();

    String errorMessageForEquals = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

    Assert.assertEquals(errorMessageForEquals,"Oops, error on page. ZIP code should have 5 digits",
            "ErrorMessage is notcorrect or system accepted data");

    driver.quit();
}

}

