package StepDefinitions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPlaceOrderStepDef {
LoginStepDef li = new LoginStepDef();
String PRODUCT = "tote";

guestAddtocartStepDef addProduct = new guestAddtocartStepDef();
@Given("I am logged in as an existing user")
public void i_am_logged_in_as_an_existing_user() {
   li.i_am_on_the_login_page();
   li.i_enter_valid_username_and_password();
   li.i_click_the_login_button();
}

@When("I add items to the cart")
public void i_add_items_to_the_cart() {
	WebElement searchBox = li.driver.findElement(By.cssSelector("input[name='q']"));
    searchBox.sendKeys(PRODUCT);
    WebElement searchButton = li.driver.findElement(By.xpath("//button[@title='Search']"));
    searchButton.click();
    List<WebElement> productElements = li.driver.findElements(By.cssSelector(".product-item"));

    // Define the number of random products to add to the cart
    int numberOfProductsToAdd = 1;

    // Select and add random products to the cart
    Random random = new Random();
    for (int i = 0; i < numberOfProductsToAdd; i++) {
        // Select a random product
        int randomIndex = random.nextInt(productElements.size());
        WebElement randomProduct = productElements.get(randomIndex);

        // Click on the random product
        randomProduct.click();

        // Wait for the product detail page to load (if needed)
	    li.driver.findElement(By.id("product-addtocart-button")).click();
    }

}

@And("I proceed to checkout")
public void i_proceed_to_checkout() {
	try {
        Thread.sleep(5000); // 3 seconds wait
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	
    li.driver.findElement(By.xpath("//div[@data-block='minicart']")).click();
    li.driver.findElement(By.linkText("View and Edit Cart")).click();
li.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button")).click();
}

@And("I enter shipping and payment information")
public void i_enter_shipping_and_payment_information() {
	try {
        Thread.sleep(3000); // 3 seconds wait
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
   li.driver.findElement(By.xpath("//input[@name='ko_unique_1']")).click();
 
   li.driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
}

@And("I place the order")
public void i_place_the_order() {
	  try {
	       Thread.sleep(5000); // 3 seconds wait
	   } catch (InterruptedException e) {
	       e.printStackTrace();
	   } 
	
    li.driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
    
}

@Then("I should see a Order Success Page")
public void i_should_see_a_order_success_page() {
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
