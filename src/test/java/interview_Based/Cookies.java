package interview_Based;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Set;

public class Cookies {

    WebDriver driver;
    @Ignore
    public void cookieset(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://vanithamani-trials711.orangehrmlive.com/auth/seamlessLogin");
        driver.manage().window().maximize();
        driver.manage().addCookie(new Cookie("hrm","sample"));
        Set<Cookie> cookie = driver.manage().getCookies();
        System.out.println(cookie);


    }
    @Test
    public void Cookies_Amazon(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://amazon.in/");
        driver.manage().window().maximize();
        //Create cookie
        Cookie newCookie = new Cookie("SampleCookies","0987654431139");
        driver.manage().addCookie(newCookie);

        /* Print the specific cookie with the name */
        Cookie sampleCookies = driver.manage().getCookieNamed("SampleCookies");
        System.out.println(sampleCookies);

        //Capture all cookies
        Set<Cookie> AllCookie =  driver.manage().getCookies(); //Store all cookie in set
        //Get the size of cookies
        System.out.println("size of All cookies: "+AllCookie.size());


        //Get all the cookies in iteration with name and value
        for(Cookie cookies: AllCookie){
            System.out.println(cookies.getName()+" : "+cookies.getValue());
        }
        //Delete the newly created cookie
        driver.manage().deleteCookie(newCookie);
        //after deletion again get the cookies
        AllCookie = driver.manage().getCookies();
        System.out.println("size of All cookies: "+AllCookie.size());

        //Verify Delete cookie is not present in the list
        for(Cookie cookies: AllCookie){
            System.out.println(cookies.getName()+" : "+cookies.getValue());
        }

        //Delete all cookies which is present
        driver.manage().deleteAllCookies();

        //after deletion again get the cookies
        AllCookie = driver.manage().getCookies();
        System.out.println("size of All cookies: "+AllCookie.size());


        //Quit the page
        driver.quit();

    }

}
