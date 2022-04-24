package testsuite;

import Utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));
        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";
        //Find the welcome text Element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));
        //sending email to email field element
        sendTextToElement(By.id("Email"), "shahbella55@gmail.com");
        //sending password to password field element
        sendTextToElement(By.name("Password"), "Bella123");
        //find log in link and click login link
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        // find the logout link and click logout link
        clickOnElement(By.linkText("Log out"));
    }

    @Test
    public void verifyTheErrorMessage() {
        // Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));
        //sending email to email field element
        sendTextToElement(By.id("Email"), "shahbella55@gmail.com");
        //sending password to password field element
        sendTextToElement(By.name("Password"), "Bella123");
        clickOnElement(By.linkText("Log in"));
        //This message from requirement
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }
}


