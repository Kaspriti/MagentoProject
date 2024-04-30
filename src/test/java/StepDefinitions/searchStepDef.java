package StepDefinitions;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchStepDef {
WebDriver driver;
String PRODUCT = "Pant";
SetUp su = new SetUp();


@Given("I am on the Magento website")
public void i_am_on_the_magento_website() {
	driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://magento.softwaretestingboard.com/");
}

@When("I enter {string} into the search bar")
public void i_enter_into_the_search_bar(String string) {
	WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
    searchBox.sendKeys(PRODUCT);
}

@And("I click the search button")
public void i_click_the_search_button(){
	WebElement searchButton = driver.findElement(By.cssSelector("button[title='Search']"));
    searchButton.click();
}

@Then("I should see a list of search results")
public void i_should_see_a_list_of_search_results() {
	
    WebElement searchResultsContainer = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]"));
    assertTrue(searchResultsContainer.isDisplayed());
}

@And("all search results should contain the word {string}")
public void all_search_results_should_contain_the_word(String string) {
	 try {
         Thread.sleep(3000); // Wait for 3 seconds (you can adjust this time as needed)
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Get the search results and print them
	 List<WebElement> searchResultItems = driver.findElements(By.cssSelector(".product-item"));

     // Iterate through each item and check if it contains the word "pant"
     for (WebElement item : searchResultItems) {
         String itemName = item.findElement(By.cssSelector(".product-item-link")).getText();
         if (itemName.toLowerCase().contains("pant")) {
             System.out.println("Search result item '" + itemName + "' contains 'pant'.");
         } else {
             System.out.println("Search result item '" + itemName + "' does not contain 'pant'.");
         }
     }
     driver.quit();}
}



