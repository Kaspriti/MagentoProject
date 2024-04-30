package StepDefinitions;

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

public class guestAddtocartStepDef {
	SetUp sp = new SetUp();
	@Given("I on the Product detail page")
	public void i_on_the_product_detail_page() {
	    sp.setUp();
	    sp.driver.get("https://magento.softwaretestingboard.com/push-it-messenger-bag.html");
	}

	@When("I click on the add to cart button")
	public void i_click_on_the_add_to_cart_button() {
	    sp.driver.findElement(By.id("product-addtocart-button")).click();
	}

	@Then("the product should get a sucess message that the product is added in the cart")
	public void the_product_should_get_a_sucess_message_that_the_product_is_added_in_the_cart() {
	    Wait<WebDriver> wait = new FluentWait<>(sp.driver)
        	    .withTimeout(Duration.ofSeconds(50))
        	    .pollingEvery(Duration.ofMillis(500))
        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

    WebElement successmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success > div")));
	//WebElement signupOrLoginPrompt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div"));
 if(successmessage.isDisplayed()) {
     // Redirected to the sign-up page or modal
     System.out.println("Product is added to cart");
     // Add your further actions here such as clicking on the sign-up link or handling modal
 } else {
     System.out.println("Product is not added to cart");
 }
}
	

	@And("in the cart the product should be visible")
	public void in_the_cart_the_product_should_be_visible() {
		 WebElement cartIcon = sp.driver.findElement(By.cssSelector("a.action.showcart"));
	        cartIcon.click();
	        try {
	            Thread.sleep(3000); // 3 seconds wait
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Find the product name in the cart
	        WebElement productInCart = sp.driver.findElement(By.cssSelector(".product-item-name"));

	        // Get the text of the product in the cart
	        String productNameInCart = productInCart.getText();

	        // Expected product name
	        String expectedProductName = "Push It Messenger Bag";

	        // Check if the product in the cart matches the expected product
	        if (productNameInCart.equals(expectedProductName)) {
	            System.out.println("Product '" + expectedProductName + "' has been successfully added to the cart!");
	        } else {
	            System.out.println("Product was not added to the cart or does not match the expected product.");
	        }

	}
}
