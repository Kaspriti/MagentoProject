package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import base.SetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class guestAddtoWishlistStepDef {
	SetUp sp =new SetUp();
	@Given("I am on the product page")
	public void i_am_on_the_product_page() {
		sp.setUp();
	    sp.driver.get("https://magento.softwaretestingboard.com/" + "olivia-1-4-zip-light-jacket.html");
	}

	@And("I am not logged in to the website")
	public void i_am_not_logged_in_to_the_website() {
		WebElement signInLink = sp.driver.findElement(By.linkText("Sign In"));
        if(signInLink.isDisplayed()) {
            System.out.println("I am a Guest user !");
        } else {
            System.out.println("I am a logged in user");
        }
	}

	@When("I click on the Add to Wishlist button")
	public void i_click_on_the_add_to_wishlist_button() {
		Wait<WebDriver> wait = new FluentWait<>(sp.driver)
        	    .withTimeout(Duration.ofSeconds(10))
        	    .pollingEvery(Duration.ofMillis(500))
        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

    WebElement signupOrLoginPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-addto-links > .towishlist > span")));
	    signupOrLoginPrompt.click();
	}

	@Then("I should be prompted to sign up or log in")
	public void i_should_be_prompted_to_sign_up_or_log_in() {
		 Wait<WebDriver> wait = new FluentWait<>(sp.driver)
	        	    .withTimeout(Duration.ofSeconds(10))
	        	    .pollingEvery(Duration.ofMillis(500))
	        	    .ignoring(org.openqa.selenium.NoSuchElementException.class);

	    WebElement signupOrLoginPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-error > div")));
		//WebElement signupOrLoginPrompt = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div"));
        if(signupOrLoginPrompt.isDisplayed()) {
            // Redirected to the sign-up page or modal
            System.out.println("User is prompted to sign up or log in.");
            // Add your further actions here such as clicking on the sign-up link or handling modal
        } else {
            System.out.println("Error: Signup or login prompt not displayed.");
        }
    }
	    

	@And("I should be redirected to the sign-in page")
	public void i_should_be_redirected_to_the_sign_in_page() {
	   String ExpectedTitle = sp.driver.getTitle();
	   String ActualTitle = "Customer Login";
	   if(ActualTitle.equals(ExpectedTitle)) {
           System.out.println("Actual title and expected title are the same: " + ActualTitle);
       } else {
           System.out.println("Actual title and expected title are different.");
           System.out.println("Expected title: " + ExpectedTitle);
           System.out.println("Actual title: " + ActualTitle);
           sp.driver.quit();       }
	}

}
