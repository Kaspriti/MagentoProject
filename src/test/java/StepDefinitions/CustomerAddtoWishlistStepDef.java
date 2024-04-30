package StepDefinitions;

import java.time.Duration;
import java.util.List;

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

public class CustomerAddtoWishlistStepDef {
	SetUp sp = new SetUp();
	@Given("I am logged in to the website")
	public void i_am_logged_in_to_the_website() {
		sp.setUp();
		sp.driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
		 sp.driver.findElement(By.id("email")).sendKeys("pritiakasar@gmail.com");
	      sp.driver.findElement(By.id("pass")).sendKeys("Test@123");
	       sp.driver.findElement(By.id("send2")).click();;

	}
	@And("Navigate to the product page")
	public void navigate_to_the_product_page() {
		WebElement searchBox = sp.driver.findElement(By.cssSelector("input[name='q']"));
	    searchBox.sendKeys("top");
	    WebElement searchButton = sp.driver.findElement(By.cssSelector("button[title='Search']"));
	    searchButton.click();
	    try {
	         Thread.sleep(3000); // Wait for 3 seconds (you can adjust this time as needed)
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	     // Get the search results and print them
		 List<WebElement> searchResults = sp.driver.findElements(By.cssSelector(".product-item"));

	     // Iterate through each item and check if it contains the word "pant"
		 if (searchResults.size() > 0) {
	            WebElement firstResult = searchResults.get(0);
	            firstResult.click();
	        } else {
	            System.out.println("No search results found.");
	        
	     }
	}

	@When("I click on the Add to Wishlist icon")
	public void i_click_on_the_add_to_wishlist_icon() {
		Wait<WebDriver> wait = new FluentWait<>(sp.driver)
        	    .withTimeout(Duration.ofSeconds(50))
        	    .pollingEvery(Duration.ofMillis(500))
        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

    WebElement signupOrLoginPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-addto-links > .towishlist > span")));
	    signupOrLoginPrompt.click();  
	}

	@Then("I should see a confirmation message")
	public void i_should_see_a_confirmation_message() {
		 Wait<WebDriver> wait = new FluentWait<>(sp.driver)
	        	    .withTimeout(Duration.ofSeconds(50))
	        	    .pollingEvery(Duration.ofMillis(500))
	        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

	    WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success > div")));
		//WebElement signupOrLoginPrompt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div"));
     if(successmessage.isDisplayed()) {
         // Redirected to the sign-up page or modal
         System.out.println("Product is added to wishlist");
         // Add your further actions here such as clicking on the sign-up link or handling modal
     } else {
         System.out.println("Product is not added to wishlist");
     }
     sp.driver.quit();

	}
}
