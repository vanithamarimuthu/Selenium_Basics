package interview_Based;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    WebDriver driver;


    //1.Methode to take screenshot
    @Test
    public void SS_File() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();

        driver.get("https://amazon.in/");
        driver.manage().window().maximize();




        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dep = new File(".//Screenshot/newSS.png");
        FileUtils.copyFile(file,dep);

        driver.quit();
    }
}
