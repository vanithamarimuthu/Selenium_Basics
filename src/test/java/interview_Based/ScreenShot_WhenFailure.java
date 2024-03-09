package interview_Based;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot_WhenFailure {
    WebDriver driver;

    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();

    }
    @Test
    public void Login_Apointment(){
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        WebElement message = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(message.getText(),"Make Appointment");
    }
    @AfterMethod
    public void closure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){

            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File des = new File(".//Screenshot/Failure.png");
            FileUtils.copyFile(scr,des);

        }

        driver.quit();
    }

}
