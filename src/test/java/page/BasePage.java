package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Redirects to indicated URL
     * @param URL Address of the site tested
     */
    public void navigateToUrl(String URL) {
        driver.get(URL);
    }

    /**
     * Gets current Browser URL.
     * @return String with current URL value.
     */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Explicitly waiting for WebElement visibility
     * @param element WebElement that will be explicitly waited.
     * @param timeout Maximum wait time in seconds.
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementDisplayed(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * @param element WebElement that will be explicitly waited.
     * @return WebElement that was explicitly waited
     */
    public WebElement waitUntilElementDisplayed(WebElement element) {
        return waitUntilElementDisplayed(element, 10);
    }
}

