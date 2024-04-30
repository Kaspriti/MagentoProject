package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class SetUp {

public WebDriver driver;
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}