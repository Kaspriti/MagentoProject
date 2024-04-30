package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logoStepDef {
WebDriver driver;
SetUp su = new SetUp();

@Given("I am on Product listing page")
public void i_am_on_product_listing_page() {
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://magento.softwaretestingboard.com/collections/yoga-new.html");
}

@When("I click on the logo")
public void i_click_on_the_logo() {
    driver.findElement(By.xpath("//a[@class='logo']")).click();
}

@Then("I should be on the Magento website homepage")
public void i_should_be_on_the_magento_website_homepage() {
    String expectedpagetitle = "Home Page";
    String actualpagetitle = driver.getTitle();
    Assert.assertEquals(actualpagetitle,expectedpagetitle);
    driver.quit();}

}
