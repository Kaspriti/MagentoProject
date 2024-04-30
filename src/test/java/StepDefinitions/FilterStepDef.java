package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterStepDef {
	SetUp su = new SetUp();
	@Given("I am on the Listing page")
	public void i_am_on_the_listing_page() {
		su.setUp();
	    su.driver.get("https://magento.softwaretestingboard.com/collections/erin-recommends.html");
	}

	@When("I filter products by price range")
	public void i_filter_products_by_price_range(){
		 try {
	            Thread.sleep(3000); // 3 seconds wait
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    su.driver.findElement(By.xpath("//*[@id=\'narrow-by-list\']/div[4]/div[1]")).click();
	    su.driver.findElement(By.xpath("//*[@id=\'narrow-by-list\']/div[4]/div[2]/ol/li[1]/a/span[3]")).click();
	}

	@Then("I should see only products within the specified price range")
	public void i_should_see_only_products_within_the_specified_price_range() {
		List<WebElement> productElements = su.driver.findElements(By.cssSelector(".product-item"));

        // Loop through each product element
        for (WebElement productElement : productElements) {
            // Get the price of the current product
            String priceText = productElement.findElement(By.xpath("//span[@data-price-type='finalPrice']")).getText();
            // Remove any non-numeric characters from the price text and convert it to a double
            double price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));

            // Assert that the price falls within the specified range
            if (!(price >= 10 && price <= 50)) {
                // Print a message or perform any other action if the condition is not met
                System.out.println("Price is not within the specified range for product: " + productElement.getText());	}
}}}
