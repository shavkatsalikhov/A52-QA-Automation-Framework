package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait (driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }
    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public void waitUntilSuccessMessageIsDisappear() {
        WaitUtils.waitUntilInvisibilityOfElement(driver, getSuccessMessage());
    }
}
