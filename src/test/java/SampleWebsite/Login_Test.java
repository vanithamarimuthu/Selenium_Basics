package SampleWebsite;

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

public class Login_Test {

    WebDriver driver;


    @BeforeMethod
    public void Setup(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=1300,1000");


        driver = new ChromeDriver(option);

        driver.get("https://practicetestautomation.com/practice-test-login/");
        //driver.manage().window().maximize();



    }
    @Test
    public  void Login_Valid(){

        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement title_dashboard = driver.findElement(By.xpath("//*[@id='loop-container']/div/article/div[1]/h1"));
        Assert.assertEquals(title_dashboard.getText(),"Logged In Successfully");

        WebElement logout_key = driver.findElement(By.xpath("//a[text()='Log out']"));
        logout_key.click();

        WebElement Test_Text = driver.findElement(By.xpath("//*[@id='login']/h2"));
        Assert.assertEquals(Test_Text.getText(),"Test login");



    }
    @Test
    public  void Login_InValid(){

        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("student1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password1231");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error = driver.findElement(By.id("error"));


        Assert.assertEquals(error.getText(),"Your username is invalid!");



    }



    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
