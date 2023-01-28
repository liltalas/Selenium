package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DayOne {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");

        driver.quit();
    }
}
