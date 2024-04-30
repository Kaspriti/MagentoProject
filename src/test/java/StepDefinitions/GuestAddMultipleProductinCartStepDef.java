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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuestAddMultipleProductinCartStepDef {
SetUp sp = new SetUp();
@Given("I am on the product listing page")
public void i_am_on_the_product_listing_page() {
    sp.setUp();
    sp.driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
}

@When("I add multiple random products to the cart")
public void i_add_multiple_random_products_to_the_cart() {
	List<WebElement> productElements = sp.driver.findElements(By.cssSelector(".product-item"));

    // Define the number of random products to add to the cart
    int numberOfProductsToAdd = 2;

    // Select and add random products to the cart
    Random random = new Random();
    for (int i = 0; i < numberOfProductsToAdd; i++) {
        // Select a random product
        int randomIndex = random.nextInt(productElements.size());
        WebElement randomProduct = productElements.get(randomIndex);

        // Click on the random product
        randomProduct.click();

        // Wait for the product detail page to load (if needed)
	    sp.driver.findElement(By.id("product-addtocart-button")).click();

        // Navigate back to the product listing page
        sp.driver.navigate().back();

        // Refresh the list of product elements
        productElements = sp.driver.findElements(By.cssSelector(".product-item"));
      }
}

@Then("the cart should contain the added products")
public void the_cart_should_contain_the_added_products() {
	Wait<WebDriver> wait = new FluentWait<>(sp.driver)
    	    .withTimeout(Duration.ofSeconds(50))
    	    .pollingEvery(Duration.ofMillis(500))
    	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.action.showcart")));
    cartIcon.click();
    WebElement miniCart = sp.driver.findElement(By.cssSelector("div.minicart-wrapper"));

    // Find the element that displays the count
    WebElement itemCountElement = miniCart.findElement(By.cssSelector(".counter-number"));

    // Get the count text
    String itemCountText = itemCountElement.getText();

    // Convert the count text to integer
    int itemCount = Integer.parseInt(itemCountText);

    // Print the count
    System.out.println("Expected items in mini cart : 2");
    System.out.println("Actual items in mini cart: " + itemCount);

    }}

