
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPageTesting extends BrowserSettings {

    String FirstNameFieldLocator = "first_name";
    String LastNameFieldLocator = "last_name";
    String EmailFieldLocator = "email";
    String Password1FieldLocator = "password1";
    String Password2FieldLocator = "password2";
    String RegisterButtonLocator = "[value = 'Register']";
    String ConfirmationMessageLocator = "[class = 'confirmation_message']";



    @Test(description = "PositivTest")
    public void registerUserWithValidData(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("Bobic");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("Bobicus");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob@gmail.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("12345");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }
    @Test(description = "NegativTest")
    public void registerUserWithInValidEmail(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("Bobic");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("Bobicus");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("12345");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }
    @Test(description = "NegativTest")
    public void registerUserWithInValidCharsInFirstName(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("@!@");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("Bobicus");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob@gmail.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("12345");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }
    @Test(description = "NegativTest")
    public void registerUserWithInValidCharsInLastName(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("Bobic");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("@!@");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob@gmail.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("12345");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }
    @Test(description = "NegativTest")
    public void registerUserWithInValidPasswordsData(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("Bobic");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("Bobicus");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob@gmail.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("12345");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }
    @Test(description = "NegativTest")
    public void registerUserWithInEmptyPasswordsData(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name(FirstNameFieldLocator)).sendKeys("Bobic");
        driver.findElement(By.name(LastNameFieldLocator)).sendKeys("Bobicus");
        driver.findElement(By.name(EmailFieldLocator)).sendKeys("bob@gmail.com");
        driver.findElement(By.name(Password1FieldLocator)).sendKeys("");
        driver.findElement(By.name(Password2FieldLocator)).sendKeys("");
        driver.findElement(By.cssSelector(RegisterButtonLocator)).click();
        boolean confirmMessage = driver.findElement(By.cssSelector(ConfirmationMessageLocator)).isDisplayed();
        Assert.assertTrue(confirmMessage, "Юзер не перешел на страницу " +
                "confirmation_message");
    }

}
