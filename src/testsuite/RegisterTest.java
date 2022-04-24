package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.linkText("Register"));

        String expectedMessage = "Register";

        String actualMessage = getTextFromElement(By.xpath("//div[@class='page-title']"));
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find register link and click on register link
        clickOnElement(By.linkText("Register"));
        //find gender radio button link and click on gender radio button link
        sendTextToElement(By.xpath("//input[@id='gender-female']"), "female");
        //find firstName  link and click on first name link
        sendTextToElement(By.id("FirstName"), "Bella");
        //find lastName  link and click on last name link
        sendTextToElement(By.id("LastName"), "Shah");
        // find the date of birth
        selectByVisibleTextFromDropDown(By.name("DateOfBirthDay"), "5");
        // find the month of birth
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"), "9");
        // find the year of the birth
        selectByVisibleTextFromDropDown(By.name("DateOfBirthYear"), "1982");
        // find the email field element
        sendTextToElement(By.xpath("//input[@id='Email']"), "shahbella55@gmail.com");
        // find the password field element
        sendTextToElement(By.id("Password"), "Bella123");
        // find the confirm password field element
        sendTextToElement(By.id("ConfirmPassword"), "Bella");
        // find the register button and the click on the register link
        clickOnElement(By.id("register-button"));
        // this message from requirement
        String expectedMessage = "Your registration completed";
        // this message from requirement
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}


