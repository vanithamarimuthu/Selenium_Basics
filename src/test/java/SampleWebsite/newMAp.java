package SampleWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class newMAp {

    @Test
    public void mappmethode(){


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        driver.manage().window().maximize();

        List<WebElement> List_States = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));
        for(WebElement e : List_States){
            System.out.println(e.getAttribute("aria-label"));
            if(e.getAttribute("aria-label").trim().equals("Tripura")) {
                new Actions(driver).moveToElement(e).click().perform();
                System.out.println("click");
            }
        }
        System.out.println("over");



    }

}
