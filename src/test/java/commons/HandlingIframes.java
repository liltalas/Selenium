package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HandlingIframes extends CommonMethods {

    @Test
    public void learnIframeHandling() throws InterruptedException {
        WebDriver driver = getDriver();
        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));

        //switching into the frame1 iframe
        driver.switchTo().frame(iframe1);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        Thread.sleep(3000);

        // going back from child frame to a parent frame
        driver.switchTo().parentFrame();
    }

    @Test
    public void learnNestedIframeHandling() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://demoqa.com/nestedframes");
        WebElement frame1 = driver.findElement(By.id("frame1"));

        // switching into parent iframe so we can find our nested child iframe
        driver.switchTo().frame(frame1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        Thread.sleep(3000);

        WebElement frame2 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));

        // switch into the second (child) iframe
        driver.switchTo().frame(frame2);

        System.out.println(driver.findElement(By.tagName("p")).getText());

        Thread.sleep(3000);

        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(3000);

        driver.switchTo().parentFrame();

        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(3000);
    }



    @Before
    public void setUp(){
        createDriver("https://demoqa.com/frames");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
