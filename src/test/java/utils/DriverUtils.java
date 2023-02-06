package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    private static WebDriver driver;
    public void createDriver(String url){
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");

        driver = new ChromeDriver();

        driver.get(url);

        // Set up an implicit wait that waits the Duration.ofSeconds() for every element while checking every 5000
        // millis before throwing NoSuchElementException
        // Note: if the element exists before the time is up it will not wait for the full time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // will maximize the window of the current driver session
        driver.manage().window().maximize();
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
