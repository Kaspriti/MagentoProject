package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkBlankShoppingCartStepDef {
	WebDriver driver;
	 SetUp sp =new SetUp();

@Given("I am on the Home page")
public void i_am_on_the_home_page() {
	sp.setUp();
    sp.driver.get("https://magento.softwaretestingboard.com");
}

@When("I click on the shopping cart icon")
public void i_click_on_the_shopping_cart_icon() throws InterruptedException {
	 WebElement cartIcon = sp.driver.findElement(By.className("minicart-wrapper"));
     cartIcon.click();

}

@Then("I should see the cart is empty")
public void i_should_see_the_cart_is_empty() {
	WebElement cartStatus = sp.driver.findElement(By.className("counter-number"));

    // Get the text of the cart status
    String cartText = cartStatus.getText();

    // Check if the cart is empty or not
    if (cartText.equals("0")) {
        System.out.println("Shopping cart is empty.");
    } else {
        System.out.println("Shopping cart is not empty. Items in cart: " + cartText);
    }


    sp.driver.quit();
}
}
