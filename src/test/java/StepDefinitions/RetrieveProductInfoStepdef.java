package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.SetUp;

import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetrieveProductInfoStepdef {
	SetUp sp = new SetUp();
	@When("I am on the product page of on the Magento website")
	public void i_am_on_the_product_page_of_on_the_magento_website() {
		sp.setUp();
	    sp.driver.get("https://magento.softwaretestingboard.com/olivia-1-4-zip-light-jacket.html");
	}

	@Then("I should display the product information")
	public void i_should_display_the_product_information() {
        WebElement moreInfoTab = sp.driver.findElement(By.id("tab-label-description-title"));
        Actions actions = new Actions(sp.driver);
        actions.moveToElement(moreInfoTab).click().perform();

        WebElement detailsContent = sp.driver.findElement(By.cssSelector("#additional"));
        String content = detailsContent.getText();
        System.out.println("More Information Content:");
        System.out.println(content);
        sp.driver.quit();
	}
//fix this
}
