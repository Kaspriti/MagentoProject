package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class advancedSearchStepDef {
SetUp su= new SetUp();
@Given("I am on homepage")
public void i_am_on_homepage() {
	su.setUp();
    su.driver.get("https://magento.softwaretestingboard.com/");
}

@When("I click on Advanced Search")
public void i_click_on_advanced_search() {
    su.driver.findElement(By.linkText("Advanced Search")).click();
    
}

@And("I enter Product name and click on search button")
public void i_enter_product_name_and_click_on_search_button() {
    su.driver.findElement(By.id("name")).sendKeys("Top");
    su.driver.findElement(By.xpath("//button[@class='action search primary']")).click();
}

@Then("I should see list of search results")
public void i_should_see_list_of_search_results() {
	WebElement searchResultsContainer = su.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]"));
    assertTrue(searchResultsContainer.isDisplayed());
}

@And("all search results should contain the Product name")
public void all_search_results_should_contain_the_product_name() {
	try {
        Thread.sleep(3000); // Wait for 3 seconds (you can adjust this time as needed)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Get the search results and print them
	 List<WebElement> searchResultItems = su.driver.findElements(By.cssSelector(".product-item"));

    // Iterate through each item and check if it contains the word "pant"
    for (WebElement item : searchResultItems) {
        String itemName = item.findElement(By.cssSelector(".product-item-link")).getText();
        if (itemName.toLowerCase().contains("top")) {
            System.out.println("Search result item '" + itemName + "' contains 'top'.");
        } else {
            System.out.println("Search result item '" + itemName + "' does not contain 'top'.");
        }
    }

}

}
