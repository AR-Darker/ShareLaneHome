package ZipCodeTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    String BASE_URL = "https://www.sharelane.com/cgi-bin/register.py";


    @BeforeMethod
    public void SetUpWindow(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//    ChromeOptions options = new ChromeOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    options.addArguments("--start-maximized");
//    options.addArguments("-incognito");
//    driver = new ChromeDriver(options;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
