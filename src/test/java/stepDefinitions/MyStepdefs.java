package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MyStepdefs {

    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebDriver driver;

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Given("I have entered date of birth")
    public void IHaveEnteredDateOfBirth() {
        driver.get(" https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.findElement(By.id("dp")).click();
        driver.findElement(By.id("dp")).sendKeys("08/11/2001");
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String name) {
        driver.findElement(By.id("member_firstname")).click();
        driver.findElement(By.id("member_firstname")).sendKeys(name);

    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String lastname) {
        driver.findElement(By.id("member_lastname")).click();
        driver.findElement(By.id("member_lastname")).sendKeys(lastname);

    }

    @And("I have entered Email address {string}")
    public void iHaveEnteredEmailAddress(String address) {
        driver.findElement(By.id("member_emailaddress")).click();
        driver.findElement(By.id("member_emailaddress")).sendKeys(address);

    }

    @And("I have confirmed Email address {string}")
    public void iHaveConfirmedEmailAddress(String address) {
        driver.findElement(By.id("member_confirmemailaddress")).click();
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(address);

    }

    @And("I have entered password {string}")
    public void iHaveEnteredPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).click();
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }


    @And("I have retyped password {string}")
    public void iHaveRetypedPassword(String password) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).click();
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password);

    }

    @And("I have checked box for marketing communications")
    public void iHaveCheckedBoxForMarketingCommunications() {
        driver.findElement(By.cssSelector(".col-sm-4:nth-child(3) .box")).click();

    }

    @And("I have checked box for Terms and Conditions")
    public void iHaveCheckedBoxForTermsAndConditions() {
        driver.findElement(By.cssSelector("label[for='sign_up_25'] > .box")).click();

    }

    @And("I have checked the box for age over {int}")
    public void iHaveCheckedTheBoxForAgeOver(int arg0) {
        driver.findElement(By.cssSelector("label[for='sign_up_26'] > .box")).click();
    }

    @And("I have checked box for Code of Ethics")
    public void iHaveCheckedBoxForCodeOfEthics() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @When("I press for confirm and join")
    public void iPressForConfirmAndJoin() {
        By joinButton = By.name("join");
        WebElement button = waitForElementVisible(joinButton, 10);
        button.click();
    }

    @Then("The application is successful")
    public void TheApplicationIsSuccessful() {
        String actual = driver.findElement(By.cssSelector("h2[class='bold  gray  text-center  margin-bottom-40']")).getText();
        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        assertEquals(expected, actual);
        // Ändra på email adress för godkänt testfall.
    }

    @Then("Missing last name for the application")
    public void missingLastNameForTheApplication() {
        WebElement lastNameField = driver.findElement(By.id("member_lastname"));
        assertTrue("Last Name is required", lastNameField.isDisplayed());

    }

    @Then("Password miss match for the application")
    public void passwordMissMatchForTheApplication() {
        // Hitta felmeddelandet för mismatch av lösenord
        String actualErrorMessage = driver.findElement(By.cssSelector("span[for='signupunlicenced_confirmpassword']")).getText();

        // Förväntat felmeddelande
        String expectedErrorMessage = "Password did not match";

        // Kontrollera att felmeddelandet är korrekt
        assertEquals(expectedErrorMessage, actualErrorMessage, "Password did not match");

    }

    @Then("The box for Terms and Conditions is not checked")
    public void theBoxForTermsAndConditionsIsNotChecked() {
        WebElement checkbox = driver.findElement(By.id("sign_up_25"));
        boolean isChecked = checkbox.isSelected();
        assertEquals("Terms and Conditions checkbox should NOT be checked", false, isChecked);
        //Det här är ett testpåstående (assertion) som säger: “Vi förväntar oss att kryssrutan inte är ikryssad.”

        //  Om isChecked råkar vara true (alltså att rutan är ikryssad), kommer testet att misslyckas och
        // felmeddelandet "Terms and Conditions checkbox should NOT be checked" visas.
    }

    @Given("User is using {string} as a webb browser")
    public void userIsUsingAsAWebbBrowser(String browser) {
        if (browser.equals("Edge"));
        {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
}