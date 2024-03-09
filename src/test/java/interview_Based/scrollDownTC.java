package interview_Based;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class scrollDownTC {
    WebDriver driver;

    @Test
    public void ScrollBy() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();



        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

          //Scroll down to the page
        js.executeScript("window.scrollBy(0,500)");

        WebElement emailTextBox = driver.findElement(By.id("philadelphia-field-email"));

        //Scroll down to find the element it is visible or not
        js.executeScript("arguments[0].scrollIntoView();",emailTextBox);

        //Send email id is using javascript - 1 method
        Thread.sleep(5000);
        //js.executeScript("arguments[0].value ='ahtniav@gmail.com'",emailTextBox);


        //Send email is using javascript - 2 method
        js.executeScript("arguments[0].value =arguments[1]",emailTextBox,"ryyyv@gmail.com");


        //Click submit button
        js.executeScript("document.getElementById('philadelphia-field-submit').click");



        driver.quit();







    }

}
