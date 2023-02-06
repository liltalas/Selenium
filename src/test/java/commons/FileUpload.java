package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class FileUpload extends DriverUtils {
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/upload-download");

    }

    @Test
    public void learnFileUpload() throws InterruptedException {
        WebDriver driver = getDriver();
        WebElement fileUploadInput = driver.findElement((By.cssSelector("#uploadFile")));

        fileUploadInput.sendKeys("/Users/syrgazamirbekova/Desktop/TestFile.txt");
        Thread.sleep(10000);
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
