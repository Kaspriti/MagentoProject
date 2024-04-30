package StepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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

public class editCustomerAddressStepDef {
	LoginStepDef li = new LoginStepDef();
	SetUp su = new SetUp();
	@Given("I am logged in as a customer")
	public void i_am_logged_in_as_a_customer() {
		li.i_am_on_the_login_page();
	    li.i_enter_valid_username_and_password();
	    li.i_click_the_login_button();
	}

	@And("I navigate to the customer address edit page")
	public void i_navigate_to_the_customer_address_edit_page() {
	    li.driver.findElement(By.linkText("Manage Addresses")).click();
	    li.driver.findElement(By.linkText("Change Billing Address")).click();
	}

	@When("I update the address details")
	public void i_update_the_address_details() {
		Random r = new Random();
        

	    WebElement Street1 = li.driver.findElement(By.id("street_1"));
	    Street1.clear();
	    Street1.sendKeys("Flat no "+ r.nextInt(100));
	    WebElement Street2 = li.driver.findElement(By.id("street_2"));
	    Street2.clear();
	    Street2.sendKeys("Wing "+ r.nextInt(100));
	    WebElement Street3 = li.driver.findElement(By.id("street_3"));
	    Street3.clear();
	    Street3.sendKeys("Road no "+ r.nextInt(100));
	    WebElement city = li.driver.findElement(By.id("city"));
	    city.clear();
	    city.sendKeys("City "+ r.nextInt(100));

	    WebElement state = li.driver.findElement(By.id("region_id"));
	    List<WebElement> options = state.findElements(By.tagName("option"));
		int randomIndex = r.nextInt(options.size());
        options.get(randomIndex).click();

	    WebElement Zip= li.driver.findElement(By.id("zip"));
	   Zip.clear();
	    Zip.sendKeys("ZipCode "+ r.nextInt(100));
	   li.driver.findElement(By.xpath("//button[@title='Save Address']")).click();
	}

	@Then("the address should be successfully updated")
	public void the_address_should_be_successfully_updated() {
		 Wait<WebDriver> wait = new FluentWait<>(li.driver)
	        	    .withTimeout(Duration.ofSeconds(50))
	        	    .pollingEvery(Duration.ofMillis(500))
	        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

	    WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success > div")));
		//WebElement signupOrLoginPrompt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div"));
  if(successmessage.isDisplayed()) {
      // Redirected to the sign-up page or modal
      System.out.println("New address updated successfully !");
      // Add your further actions here such as clicking on the sign-up link or handling modal
  } else {
      System.out.println("Address not updated !");
  }
  li.driver.quit();
	}
}
