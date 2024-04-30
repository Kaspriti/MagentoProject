package StepDefinitions;

import org.openqa.selenium.By;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class privacypolicynavigationStepDef {
	SetUp su = new SetUp();
	@Given("I am the homepage")
	public void i_am_the_homepage() {
	    su.setUp();
	    su.driver.get("https://magento.softwaretestingboard.com/");
	}

	@When("I click on Privacy page link")
	public void i_click_on_privacy_page_link() {
	    su.driver.findElement(By.linkText("Privacy and Cookie Policy")).click();
	    
	}

	@Then("I should be redirected to Privacy page")
	public void i_should_be_redirected_to_privacy_page() {
		String ExpectedTitle = su.driver.getTitle();
		   String ActualTitle = "Privacy Policy";
		   if(ActualTitle.equals(ExpectedTitle)) {
	           System.out.println("Actual title and expected title are the same: " + ActualTitle);
	       } else {
	           System.out.println("Actual title and expected title are different.");
	           System.out.println("Expected title: " + ExpectedTitle);
	           System.out.println("Actual title: " + ActualTitle);
	           su.driver.quit();    
	  
	}
	}}
