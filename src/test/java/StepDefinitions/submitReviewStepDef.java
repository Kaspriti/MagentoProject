package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import base.SetUp;

import java.time.Duration;
import java.util.List; // Import correct List class

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class submitReviewStepDef {
	WebDriver driver;
	 SetUp sp =new SetUp();

@Given("I am on the product page\"")
public void i_am_on_the_product_page() {
		sp.setUp();
	    sp.driver.get("https://magento.softwaretestingboard.com/" + "olivia-1-4-zip-light-jacket.html");
	}

	@When("I click on the Reviews button")
	public void i_click_on_the_reviews_button() {
        WebElement addReviewButton = sp.driver.findElement(By.xpath("//a[@class='action add']"));
        addReviewButton.click();

	}

	@And("I fill in the review form with my details")
	public void i_fill_in_the_review_form_with_my_details() {
		
		Wait<WebDriver> wait = new FluentWait<>(sp.driver)
	            .withTimeout(Duration.ofSeconds(50))
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(org.openqa.selenium.NoSuchElementException.class);

	    // Wait for the star rating element to be clickable
	    WebElement ratingStar = wait.until(ExpectedConditions.elementToBeClickable(By.id("Rating_1_label")));

	    // Click on the star rating
	    ratingStar.click();
		
		//Actions actions = new Actions(sp.driver);
		//actions.moveToElement(ratingStar).click().perform();
		  WebElement nicknameInput = sp.driver.findElement(By.id("nickname_field"));
	        nicknameInput.sendKeys("YourNickname");

	       WebElement summary = sp.driver.findElement(By.id("summary_field"));
	        summary.sendKeys("YourReviewTitle");

	        WebElement reviewbox = sp.driver.findElement(By.id("review_field"));
	        reviewbox.sendKeys("YourReviewDetail");
	}

	@And("I submit the review")
	public void i_submit_the_review() {
		  WebElement submitButton = sp.driver.findElement(By.xpath("//button[@class='action submit primary']"));
	        submitButton.click();
	}

	@Then("I should see a success message confirming the review submission")
	public void i_should_see_a_success_message_confirming_the_review_submission() {
		Wait<WebDriver> wait = new FluentWait<>(sp.driver)
        	    .withTimeout(Duration.ofSeconds(50))
        	    .pollingEvery(Duration.ofMillis(500))
        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message-success")));
		

    // Check if the cart is empty or not
    if (successMessage.isDisplayed()) {
        System.out.println("You submitted your review for moderation.");
    } else {
        System.out.println("Review not submitted ");
    }
sp.driver.quit();}
}
