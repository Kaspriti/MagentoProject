package base;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
	
 public static WebDriver driver;
 public static Properties prop = new Properties();
 public static FileReader fr;

	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}