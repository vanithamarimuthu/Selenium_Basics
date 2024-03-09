import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium_Basic {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions();


        option.setPageLoadStrategy(PageLoadStrategy.EAGER);

        WebDriver driver = new ChromeDriver(option);



        driver.get("https://www.opencart.com/index.php?route=account/login");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement test =driver.findElement(By.xpath("//*[@id='account-login']/div[1]/div/h1"));

        System.out.println("pass");
        driver.quit();

    }
}
