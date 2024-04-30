package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class guestDeleteProductFromCartStepDef {
	guestAddtocartStepDef AddProduct = new guestAddtocartStepDef();

	@Given("Add the Product into the cart")
	public void add_the_product_into_the_cart() {
		AddProduct.i_on_the_product_detail_page();
		AddProduct.i_click_on_the_add_to_cart_button();
		AddProduct.the_product_should_get_a_sucess_message_that_the_product_is_added_in_the_cart();
		AddProduct.in_the_cart_the_product_should_be_visible();
	}

	@When("I click on the delete icon")
	public void i_click_on_the_delete_icon() {
		WebElement deleteIcon = AddProduct.sp.driver.findElement(By.xpath("//a[@title='Remove item']"));
		deleteIcon.click();
	}

	@And("I click Ok from the pop up box")
	public void i_click_ok_from_the_pop_up_box() {

		Wait<WebDriver> wait = new FluentWait<>(AddProduct.sp.driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(500)).ignoring(org.openqa.selenium.NoSuchElementException.class);

		WebElement okButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class=\"action-primary action-accept\"]")));
		okButton.click();
	}

	@Then("the product should get deleted from the cart")
	public void the_product_should_get_deleted_from_the_cart() {

		WebElement miniCartIcon = AddProduct.sp.driver.findElement(By.cssSelector("a.action.showcart"));
		miniCartIcon.click();

		try {
			Thread.sleep(2000); // Adjust the wait time as needed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> productElements = AddProduct.sp.driver
				.findElements(By.cssSelector("div.minicart-wrapper ol.minicart-items li"));
		WebElement cartIcon = AddProduct.sp.driver.findElement(By.cssSelector("a.action.showcart"));
		cartIcon.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Product Details from Mini Cart:");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (WebElement productElement : productElements) {
			WebElement productNameElement = productElement
					.findElement(By.xpath("//strong[@class='product-item-name']"));
			String productName = productNameElement.getText();
			System.out.println("Product Name: " + productName);
			System.out.println("------------------------");
			{
				String expectedProductName = "Push It Messenger Bag";

				if (productName.equals(expectedProductName)) {
					System.out.println("Product '" + expectedProductName + "' is still in the cart !");
				} else {
					System.out.println("Product is successfully deleted from the cart");
				}
			}
		}
		System.out.println("Product deleted from the cart");
		AddProduct.sp.driver.quit();
	}
	
}
