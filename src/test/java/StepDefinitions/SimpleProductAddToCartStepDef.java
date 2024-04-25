package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleProductAddToCartStepDef {
	WebDriver driver;
	@Given("I am on the product page of Overnight Duffle on the Magento website")
	public void i_am_on_the_product_page_of_overnight_duffle_on_the_magento_website() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://magento.softwaretestingboard.com/voyage-yoga-bag.html");
	    
	}

	@When("I click on the Add to Cart button")
	public void i_click_on_the_add_to_cart_button() {
	    driver.findElement(By.id("product-addtocart-button")).click();
	   
	}

	@Then("I should see a confirmation message indicating the product has been added to the cart")
	public void i_should_see_a_confirmation_message_indicating_the_product_has_been_added_to_the_cart() throws InterruptedException {
		 WebElement cartIcon = driver.findElement(By.cssSelector(".top-link-cart .count"));
	        String cartItemCount = cartIcon.getText();
	        System.out.println("Cart Item Count: " + cartItemCount);
	        //fix
		
	}

}
