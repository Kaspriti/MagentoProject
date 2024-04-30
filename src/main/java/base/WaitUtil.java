package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class WaitUtil {
SetUp sp = new SetUp();
    public WaitUtil(WebDriver driver) {
        sp.driver = driver;
    }

    public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new FluentWait<>(sp.driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}