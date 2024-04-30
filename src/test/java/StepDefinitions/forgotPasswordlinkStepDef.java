package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class forgotPasswordlinkStepDef {
WebDriver driver;
SetUp sp =new SetUp();
@Given("I am on the Magento website login page")
public void i_am_on_the_magento_website_login_page() {
	sp.setUp();
    sp.driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
}

@When("I click on the Forgot Your Password? link")
public void i_click_on_the_forgot_your_password_link() {
	WebElement forgotPasswordLink = sp.driver.findElement(By.linkText("Forgot Your Password?"));
    forgotPasswordLink.click();
}

@And("I enter my email address into the email field")
public void i_enter_my_email_address_into_the_email_field() {
	 WebElement emailField = sp.driver.findElement(By.id("email_address"));
     emailField.sendKeys("abc@gmail.com");
}

@And("I click on the Reset My Password button")
public void i_click_on_the_reset_my_password_button() throws InterruptedException {
	WebElement resetButton = sp.driver.findElement(By.xpath("//button[@class=\"action submit primary\"]"));
    resetButton.click();}

@Then("I should see a success message indicating that the password reset email has been sent")
public void i_should_see_a_success_message_indicating_that_the_password_reset_email_has_been_sent() {
	Wait<WebDriver> wait = new FluentWait<>(sp.driver)
    	    .withTimeout(Duration.ofSeconds(10))
    	    .pollingEvery(Duration.ofMillis(500))
    	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

WebElement successMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success > div")));
	//WebElement successMessage = w.waitForElementVisible(By.cssSelector(".message-success > div"),10);
	//WebElement successMessage = driver.findElement(By.cssSelector(".message-success > div"));

    // Verify if the success message is displayed or contains the expected text
    if (successMessage.isDisplayed() && successMessage.getText().contains(" reset your password")) {
        System.out.println("Success message appeared: " + successMessage.getText());
    } else {
        System.out.println("Success message did not appear or did not contain the expected text.");
    }
}

@And("I enter an invalid email address into the email field")
public void i_enter_an_invalid_email_address_into_the_email_field() {
	 WebElement emailField = sp.driver.findElement(By.id("email_address"));
     emailField.sendKeys("invalid_email");
}

@Then("I should see an error message indicating that the email address is invalid")
public void i_should_see_an_error_message_indicating_that_the_email_address_is_invalid() {
	WebElement errorMessage = sp.driver.findElement(By.xpath("//div[@id=\'email_address-error\']"));
    assertTrue(errorMessage.isDisplayed());
    sp.driver.quit();
}


}


