package StepDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	 WebDriver driver;
		SetUp su = new SetUp();

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		 driver.findElement(By.id("email")).sendKeys("pritiakasar@gmail.com");
	      driver.findElement(By.id("pass")).sendKeys("Test@123");
	}

	@And("I click the login button")
	public void i_click_the_login_button() {
       driver.findElement(By.id("send2")).click();;

	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}


	@When("I enter invalid username and invalid password")
	public void i_enter_invalid_username_and_invalid_password() {
		 driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	      driver.findElement(By.id("pass")).sendKeys("Test@12345");
	}

	@Then("I should see an error message indicating invalid credentials")
	public void i_should_see_an_error_message_indicating_invalid_credentials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement errorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message.error")));
		String actualErrorMessage = errorMessage.getText();
		String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected.");
		
	}	
}
