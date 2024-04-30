package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class getMessageGlobalStepDef {
	SetUp su = new SetUp();
	@Given("I am the Magento homepage")
	public void i_am_the_magento_homepage() {
		su.setUp();
	    su.driver.get("https://magento.softwaretestingboard.com/");
	}

	@Then("If global message is displayed")
	public void if_global_message_is_displayed() {
		WebElement GlobalMsg = su.driver.findElement(By.xpath("//div[@class='message global demo']"));
		WebElement GlobalMsgText = su.driver.findElement(By.xpath("/html/body/div[1]/div/p"));
	   if(GlobalMsg.isDisplayed()) {
		   System.out.println("Global Message is : "+ GlobalMsgText.getText());
	   }else {
		   System.out.println("Global Message is not present");
	   }
	}


}
