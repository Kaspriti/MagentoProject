package guestAddtocart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class guestAddtocartStepDef {
	WebDriver driver;
	 SetUp sp =new SetUp();

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		sp.setUp();
        sp.driver.get("https://magento.softwaretestingboard.com");
	}

	@When("I go to HotSellers section")
	public void i_go_to_hot_sellers_section() {
		 int xCoordinate = 1296;
	        int yCoordinate = 688;
	        scrollToPosition(driver, xCoordinate, yCoordinate);
	}

	private void scrollToPosition(WebDriver driver2, int xCoordinate, int yCoordinate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(arguments[0], arguments[1]);", xCoordinate, yCoordinate);
		
	}

	@And("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
		 WebElement product = driver.findElement(By.xpath("//a[contains(@title,'Radiant Tee')]"));
	        product.click();

	        // Select xs size
	        WebElement sizeDropdown = driver.findElement(By.id("option-label-size-143-item-166"));
	        sizeDropdown.click();

	        // Select blue color
	        WebElement colorSwatch = driver.findElement(By.id("option-label-color-93-item-50"));
	        colorSwatch.click();

	        // Add to cart
	        WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
	        addToCartButton.click();

	}

	@Then("I should see a success message confirming the product has been added to the cart")
	public void i_should_see_a_success_message_confirming_the_product_has_been_added_to_the_cart() {
		// Wait for the success message to appear
        Wait<WebDriver> wait = new FluentWait<>(driver)
        	    .withTimeout(Duration.ofSeconds(10))
        	    .pollingEvery(Duration.ofMillis(500))
        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

        	WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ui-id='message-success']")));
        
        // Print success message
        System.out.println(successMessage.getText());

	    sp.tearDown();
			}

}
