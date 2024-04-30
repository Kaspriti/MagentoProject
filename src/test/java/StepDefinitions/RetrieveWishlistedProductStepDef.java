package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetrieveWishlistedProductStepDef {
	SetUp su = new SetUp();
	LoginStepDef li = new LoginStepDef();
	@Given("I am log in as a customer")
	public void i_am_log_in_as_a_customer() {
		li.i_am_on_the_login_page();
	    li.i_enter_valid_username_and_password();
	    li.i_click_the_login_button();
	  
	}

	@When("I navigate to the wishlist page")
	public void i_navigate_to_the_wishlist_page() {
		  li.driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		    li.driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")).click();
	}

	@Then("I should see the list of products in my wishlist")
	public void i_should_see_the_list_of_products_in_my_wishlist() {
		  List<WebElement> productElements = li.driver.findElements(By.cssSelector(".product-item-info"));
	        System.out.println("Product Names in Wishlist:");
	        for (WebElement productElement : productElements) {
	            String productName = productElement.findElement(By.cssSelector("a.product-item-link")).getText().trim();
	            System.out.println(productName);
	        }
	        li.driver.quit();

	}
    

}
