package StepDefinitions;

import org.openqa.selenium.By;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReorderStepDef {
	LoginStepDef li = new LoginStepDef();
	SetUp su = new SetUp();

	@Given("I am logged in user")
	public void i_am_logged_in_user() {
		li.i_am_on_the_login_page();
		   li.i_enter_valid_username_and_password();
		   li.i_click_the_login_button();
	}
	@Given("I navigate to the My Orders page")
	public void i_navigate_to_the_my_orders_page() {
	   li.driver.findElement(By.linkText("View All")).click();
	   li.driver.findElement(By.linkText("View Order")).click();
	   try {
	       Thread.sleep(5000); // 3 seconds wait
	   } catch (InterruptedException e) {
	       e.printStackTrace();
	   }
	}

	@When("I proceed to reorder the selected order")
	public void i_proceed_to_reorder_the_selected_order() {
		try {
		       Thread.sleep(2000); // 3 seconds wait
		   } catch (InterruptedException e) {
		       e.printStackTrace();
		   }
		li.driver.findElement(By.linkText("Reorder")).click();;
	}

	@Then("I should be redirected to the cart page to complete the order")
	public void i_should_be_redirected_to_the_cart_page_to_complete_the_order() {
		try {
		       Thread.sleep(10000); // 3 seconds wait
		   } catch (InterruptedException e) {
		       e.printStackTrace();
		   }
		li.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button")).click();
		try {
	        Thread.sleep(3000); // 3 seconds wait
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	   li.driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
	 
	   li.driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
	   try {
	       Thread.sleep(5000); // 3 seconds wait
	   } catch (InterruptedException e) {
	       e.printStackTrace();
	   } 
	
    li.driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
    try {
	       Thread.sleep(5000); // 3 seconds wait
	   } catch (InterruptedException e) {
	       e.printStackTrace();
	   } 
String ActTitle =   li.driver.getTitle();
// Expected product name
String ExpectTitle = "Thank you for your purchase!";

// Check if the product in the cart matches the expected product
if (ActTitle.equals(ExpectTitle)) {
    System.out.println("Order placed Successfully !");
} else {
    System.out.println("Order not Placed.");
}
li.driver.quit();
	}
}
