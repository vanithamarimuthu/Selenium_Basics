package VWO_TC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;




    @BeforeMethod
    public void Setup(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=1300,1000");


        driver = new ChromeDriver(option);

        driver.get("https://app.vwo.com/#/login");
        //driver.manage().window().maximize();


        
    }
    @Test
    public  void LoginVWO_Valid(){

        WebElement username= driver.findElement(By.id("login-username"));
        username.sendKeys("ahtniav@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("V@nitha04");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String title_dashboard = driver.getTitle();
        Assert.assertEquals(title_dashboard,"Dashboard");



    }
    @Test
    public  void LoginVWO_InValid(){
        WebElement username= driver.findElement(By.id("login-username"));
        username.sendKeys("ahtniav@gmail.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("password");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error = driver.findElement(By.id("js-notification-box-msg"));


        Assert.assertEquals(error.getText(),"Your email, password, IP address or location did not match");



    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
