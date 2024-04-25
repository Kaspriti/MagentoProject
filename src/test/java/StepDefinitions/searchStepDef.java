package StepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchStepDef {
WebDriver driver;
String PRODUCT = "Pant";


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
    java.util.List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-item-info a"));
        for (WebElement result : searchResults) {
            for(int i = 0; i<searchResults.size();i++) {
				String temp = searchResults.get(i).getText();
 
				if ((temp.contains(PRODUCT))){
					Assert.assertTrue(true, PRODUCT +" is displayed on product title Product Title: " + temp);
				}else {
					Assert.assertTrue(false, PRODUCT + " is not displayed on product title Product Title: " + temp);
		
				}
}//fix this
        }
}
}



