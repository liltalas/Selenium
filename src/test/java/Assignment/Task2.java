package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class Task2 extends DriverUtils {

   /*
   Xpath Homework
Open http://18.116.88.132:8080/bank/login and create an account DO NOT USE ANY REAL PERSONAL INFO WHEN CREATING AN ACCOUNT.
(Use fake info like 123 Address St for address)
 -  After creating an account sign in.

    */

    //***** Use relative xpath to find the “My profile” <a> tag *****
    // answer: //a[@href='/bank/user/profile']

    //***** Use relative xpath to find the “Deposit Menu” <a> (anchor tag) *****
    // answer: //a[@href='/bank/account/deposit']

    // Use relative xpath along with the contains() method to find the “Checking” drop down <a> tag
    // answer: //*[contains(@id,'checking-menu')]

    // After finding the locator for the “Checking” dropdown add onto that same locator in order to find
    // the “New Checking” link <a> tag
    // answer: //*[contains(@id,'checking-menu')]//following::a[contains(text(), 'New Checking')]

    /*
    Advanced Homework
Note: This is an option to practice axes.
Finally, after that add an axe onto that same locator and find the “New Savings” <a> tag under the “Savings” drop down.

    // answer: //*[contains(@id,'checking-menu')]//following::a[contains(text(), 'New Checking')]
    //following::a[@id='new-savings-menu-item']

     */




}
