package interview_Based;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowHandling {
    @Test
    public void windowsHandle(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        System.out.println("Current window"+driver.getTitle());

        //Created new tab and launched url

       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://www.flipkart.com/");


       //New Window created
       driver.switchTo().newWindow(WindowType.WINDOW);

       driver.get("https://www.myntra.com/");

       //Current window
       String current= driver.getWindowHandle();

        System.out.println("Current window"+current);

       // all windows stored in set variable
       Set<String> all_window = driver.getWindowHandles();

        System.out.println("Size of windows"+all_window.size());

        //List to store the all windows

        List<String> List = new ArrayList<String>();


        List.addAll(all_window);
        //switch to first window and closed
        driver.switchTo().window(List.get(0));
        System.out.println("First Window "+driver.getTitle());
        driver.close();

        //switch to second window and closed
        driver.switchTo().window(List.get(1));
        System.out.println("second Window "+driver.getTitle());
        driver.close();

        //switch to 3rd window and closed
        driver.switchTo().window(List.get(2));
        System.out.println("3rd Window "+driver.getTitle());
        driver.quit();






    }
}
