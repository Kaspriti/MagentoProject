package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logoutStepDef {
	LoginStepDef li = new LoginStepDef();
	@Given("I have logged in")
	public void i_have_logged_in() {
		li.i_am_on_the_login_page();
	    li.i_enter_valid_username_and_password();
	    li.i_click_the_login_button();
	    System.out.println("I am logged in Customer");
	}

	@When("I click on Sign out")
	public void i_click_on_sign_out() {
		 li.driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		 li.driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		 
	}

	@Then("I should be logged out")
	public void i_should_be_logged_out() {
		WebElement signInLink = li.driver.findElement(By.linkText("Sign In"));
        if(signInLink.isDisplayed()) {
            System.out.println("I am a Guest user !");
        } else {
            System.out.println("I am a logged in user");
        }
	}


}
