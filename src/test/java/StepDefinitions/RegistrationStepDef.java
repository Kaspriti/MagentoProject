package StepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.SetUp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDef {
	 WebDriver driver;
	 SetUp sp =new SetUp();
	@Given("I am on the Registration page")
	public void i_am_on_the_registration_page() {
		sp.setUp();
        sp.driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	}

	@When("I enter FirstName and LastName")
	public void i_enter_first_name_and_last_name() {
		sp.driver.findElement(By.id("firstname")).sendKeys("John");
	      sp.driver.findElement(By.id("lastname")).sendKeys("Doe");
	}

	@And("I enter Email")
	public void i_enter_email() {
        Random random = new Random();
		 int randomNumber = random.nextInt(1000);
	  WebElement email_address = sp.driver.findElement(By.id("email_address"));
	 email_address.sendKeys("testcustomer+" + randomNumber + "@gmail.com" );
	}

	@And("I enter Password and ConfirmPassword")
	public void i_enter_password_and_confirm_password() {
	   sp.driver.findElement(By.id("password")).sendKeys("Test@987");
	    sp.driver.findElement(By.id("password-confirmation")).sendKeys("Test@987");
	}

	@And("I click on CreateanAccount button")
	public void i_click_on_createan_account_button() {
	    sp.driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
	}

	@Then("I should be registered successfully")
	public void i_should_be_registered_successfully() {
		String actualTitle = sp.driver.getTitle();
		String expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		sp.driver.quit();	}


}
