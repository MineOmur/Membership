
package steps;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.time.Duration;
import java.util.UUID;

import static org.junit.Assert.assertTrue;


public class RegistrationStepdefs {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String uniqecode = String.valueOf(UUID.randomUUID());
    String email = "eymen.test+" + System.currentTimeMillis() + "@gmail.com";

    private void waitAndClick(String css){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();
    }


    @Given("I am on the registration page using {string}")
    public void iAmOnTheRegistrationPage(String browser) {
        // driver = new ChromeDriver();
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I fill in the registration form with valid details")
    public void iFillInTheRegistrationFormWithValidDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("dp")).sendKeys("01/01/1990");  // Date of Birth
        driver.findElement(By.id("member_firstname")).sendKeys("Eymen");  // First Name
        driver.findElement(By.id("member_lastname")).sendKeys("Test");  // Last Name
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);  // Email Address
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);  // Confirm Email Address
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");  // Confirm Password
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");  // Password
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']\n")).click();


    }

    @When("I fill in the registration form with missing last name")
    public void iFillInTheRegistrationFormWithMissingLastName() {
        driver.findElement(By.id("dp")).sendKeys("01/01/1990");
        driver.findElement(By.id("member_firstname")).sendKeys("Eymen");
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);  // Email Address
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");

        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']\n")).click();


    }

    @When("I fill in the registration form with mismatched passwords")
    public void iFillInTheRegistrationFormWithMismatchedPasswords() {
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']\n")).click();


        driver.findElement(By.id("dp")).sendKeys("01/01/1990");
        driver.findElement(By.id("member_firstname")).sendKeys("Eymen");
        driver.findElement(By.id("member_lastname")).sendKeys("Test");
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);  // Email Address
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("DifferentPassword123");


    }

    @When("I fill in the registration form without accepting terms and conditions")
    public void iFillInTheRegistrationFormWithoutAcceptingTermsAndConditions() {
        driver.findElement(By.id("dp")).sendKeys("01/01/1990");
        driver.findElement(By.id("member_firstname")).sendKeys("Eymen");
        driver.findElement(By.id("member_lastname")).sendKeys("Test");
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);  // Email Address
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");


    }

    @When("I fill in the registration form with an invalid email format")
    public void iFillInTheRegistrationFormWithAnIinvalidEmailFormat() {
        driver.findElement(By.id("dp")).sendKeys("01/01/1990");
        driver.findElement(By.id("member_firstname")).sendKeys("Eymen");
        driver.findElement(By.id("member_lastname")).sendKeys("Test");
        driver.findElement(By.id("member_emailaddress")).sendKeys("eymen.test@");  // Invalid Email Format
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("eymen.test@");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Password123");
        driver.findElement(By.cssSelector("label[for='sign_up_25'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span[class='box']\n")).click();
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span[class='box']\n")).click();


    }

    @Then("I submit the form")
    public void iSubmitTheForm() {
        waitAndClick("input[name='join']");
    }

    @Then("I should see a successful registration message")
    public void iShouldSeeASuccessfulRegistrationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(), 'THANK YOU FOR CREATING AN ACCOUNT')]")
            ));
            System.out.println("✅ Success Message: " + successMessage.getText());
            assertTrue(successMessage.isDisplayed());
        } catch (Exception e) {
            System.out.println("❌ Success message not found!");
            throw e; // Hatanın test tarafından da görülmesi için yeniden fırlatıyoruz
        }
    }

    @Then("I should see a last name required error")
    public void iShouldSeeALastNameRequiredError() {
        try {
            WebElement error = driver.findElement(By.cssSelector("span[for='member_lastname']"));
            System.out.println("❌ Last Name Error: " + error.getText());
            assertTrue(error.isDisplayed());
        } catch (Exception e) {
            System.out.println(" Last Name error message not found.");
        }
    }

    @Then("I should see a password mismatch error")
    public void iShouldSeeAPasswordMismatchError() {
        try {
            WebElement error = driver.findElement(By.cssSelector("span[for='signupunlicenced_confirmpassword']"));
            System.out.println("❌ Password Mismatch Error: " + error.getText());
            assertTrue(error.isDisplayed());
        } catch (Exception e) {
            System.out.println(" Password mismatch error message not found.");
        }
    }

    @Then("I should see terms and conditions errors")
    public void iShouldSeeTermsAndConditionsErrors() {
        WebElement termsError = driver.findElement(By.cssSelector("span[for='TermsAccept']"));
        WebElement ageError = driver.findElement(By.cssSelector("span[for='AgeAccept']"));
        WebElement ethicsError = driver.findElement(By.cssSelector("span[for='AgreeToCodeOfEthicsAndConduct']"));

        assertTrue(termsError.getText().contains("You must confirm that you have read and accepted our Terms and Conditions"));
        assertTrue(ageError.getText().contains("You must confirm that you are over 18 or a person with parental responsibility"));
        assertTrue(ethicsError.getText().contains("You must confirm that you have read, understood and agree to the Code of Ethics and Conduct"));
    }

    @Then("I should see an invalid email error")
    public void iShouldSeeAnInvalidEmailError() {
        try {
            WebElement error = driver.findElement(By.cssSelector("span[for='member_emailaddress']"));
            System.out.println("❌ Invalid Email Format Error: " + error.getText());
            assertTrue(error.isDisplayed());
        } catch (Exception e) {
            System.out.println(" Invalid email format error message not found.");
        }

    }
    @After
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            System.out.println(" Browser closed successfully.");
        } else {
            System.out.println(" WebDriver was null, browser not closed.");
        }
    }
}