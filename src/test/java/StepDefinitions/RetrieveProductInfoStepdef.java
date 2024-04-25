package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetrieveProductInfoStepdef {
	WebDriver driver;
	@When("I am on the product page of on the Magento website")
	public void i_am_on_the_product_page_of_on_the_magento_website() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://magento.softwaretestingboard.com/olivia-1-4-zip-light-jacket.html");
	}

	@Then("I should display the product information")
	public void i_should_display_the_product_information() {
		WebElement productNameElement = driver.findElement(By.cssSelector(".product-name span"));
        String productName = productNameElement.getText();
        System.out.println("Product Name: " + productName);

        // Retrieve product price
        WebElement productPriceElement = driver.findElement(By.cssSelector(".price"));
        String productPrice = productPriceElement.getText();
        System.out.println("Product Price: " + productPrice);

        // Retrieve product description
        WebElement productDescriptionElement = driver.findElement(By.cssSelector(".product.attribute.description"));
        String productDescription = productDescriptionElement.getText();
        System.out.println("Product Description: " + productDescription);
	}
//fix this
}
