package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class editQtyofProductfromCartStepDef {
	LoginStepDef li = new LoginStepDef();
	SetUp su = new SetUp();

	@Given("I am logged in customer")
	public void i_am_logged_in_customer() {
	    li.i_am_on_the_login_page();
	    li.i_enter_valid_username_and_password();
	    li.i_click_the_login_button();
	}

	@And("I am on the cart page")
	public void i_am_on_the_cart_page() {
		try {
            Thread.sleep(3000); // 3 seconds wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	    li.driver.findElement(By.xpath("//div[@data-block='minicart']")).click();
	    try {
            Thread.sleep(3000); // 3 seconds wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    li.driver.findElement(By.linkText("View and Edit Cart")).click();
	}

	@When("I edit the quantity of a random product")
	public void i_edit_the_quantity_of_a_random_product() {
	    WebElement qty = li.driver.findElement(By.xpath("//input[@title='Qty']"));
	    WebElement quantityInput = li.driver.findElement(By.cssSelector(".cart.item input.qty"));

        // Clear the quantity input field
        quantityInput.clear();

        // Set a new quantity (e.g., 2)
        quantityInput.sendKeys("2");
        WebElement updateButton = li.driver.findElement(By.cssSelector("button.update"));
        updateButton.click();

	}

	@Then("the updated quantity should be reflected in the cart")
	public void the_updated_quantity_should_be_reflected_in_the_cart() {
		List<WebElement> productElements = li.driver.findElements(By.cssSelector(".cart.item"));

        // Iterate through each product element in the cart
        for (WebElement productElement : productElements) {
            // Get the product name
            WebElement productNameElement = productElement.findElement(By.cssSelector(".product-item-name"));
            String productName = productNameElement.getText();

            // Get the quantity
            WebElement quantityElement = productElement.findElement(By.cssSelector("input.qty"));
            String quantity = quantityElement.getAttribute("value");

            // Print the product name and quantity
            System.out.println("Product: " + productName + ", Quantity: " + quantity);
        }

		li.driver.quit();
	}
}
