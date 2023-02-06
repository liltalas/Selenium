package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropDowns extends CommonMethods {


    @Test
    public void learnDropDowns() throws InterruptedException {
        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        WebElement dropdown = driver.findElement(By.xpath("//select"));
        WebElement selectCountryTitle = driver.findElement(By.id("Select Country"));

        System.out.println(selectCountryTitle.getAttribute("id"));
        System.out.println(selectCountryTitle.getAttribute("class"));
        System.out.println(selectCountryTitle.getAttribute("aria-controls"));
        System.out.println(selectCountryTitle.getAttribute("role"));

        System.out.println("-----------------------------------------------------");

        //Select class has a constructor with parameter WebElement therefore we need to pass an element to the class
        //The element we pass should be the dropdown we want to manipulate

        Select countriesDropDown = new Select(dropdown);

        //System.out.println(countriesDropDown.getOptions().get(1).getText());

        // method returns a List<WebElement> of all the options tags that are children
        // to the current select tag
        List<WebElement> optionList = countriesDropDown.getOptions();

        //Cycling through a list of options created on line 34 and printing the text stored inside the tag and the
        // attribute "value"
        for(WebElement option: optionList){
            System.out.println(option.getText() + "\t" + option.getAttribute("value"));
        }


        //Select class has a lot of different methods that do various different things such as selecting specific
        //option in side of the select tag, returning a specific value, and etc..
        countriesDropDown.selectByVisibleText("Bermuda");

        Thread.sleep(3000);

    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");

    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
