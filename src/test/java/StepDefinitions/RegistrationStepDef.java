package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDef {
	 WebDriver driver;

	@Given("I am on the Registration page")
	public void i_am_on_the_registration_page() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	}

	@When("I enter FirstName and LastName")
	public void i_enter_first_name_and_last_name() {
		driver.findElement(By.id("firstname")).sendKeys("John");
	      driver.findElement(By.id("lastname")).sendKeys("Doe");
	}

	@And("I enter Email")
	public void i_enter_email() {
	    driver.findElement(By.id("email_address")).sendKeys("testcustomer+4@example.com");
	}

	@And("I enter Password and ConfirmPassword")
	public void i_enter_password_and_confirm_password() {
	    driver.findElement(By.id("password")).sendKeys("Test@987");
	    driver.findElement(By.id("password-confirmation")).sendKeys("Test@987");
	}

	@And("I click on CreateanAccount button")
	public void i_click_on_createan_account_button() {
	    driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
	}

	@Then("I should be registered successfully")
	public void i_should_be_registered_successfully() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Account";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}


}
