package VWO_TC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Google {
    static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


    }

    @Test
    public void collectData() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("Taj");
        Thread.sleep(3000);
        List<WebElement> Data_Searched = driver.findElements(By.xpath("//div[@class='OBMEnb']//ul//li"));
        int size = Data_Searched.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
            System.out.println(Data_Searched.get(i));
        }
        Data_Searched.get(size-6).click();


    }


    @AfterTest
    public void closure(){
        driver.close();
    }
}
