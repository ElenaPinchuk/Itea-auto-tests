package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegistrationPage extends BasePage {

    @FindBy(id = "reg-firstname")
    private WebElement firstNameField;

    @FindBy(id = "reg-lastname")
    private WebElement lastNameField;

    @FindBy(id = "reg-email")
    private WebElement emailField;

    @FindBy(id = "reg-password")
    private WebElement passwordField;

    @FindBy(id = "registration-submit")
    private WebElement joinNowButton;

    @FindBy(className = "alert-content")
    private WebElement errorMessageBox;

    @FindBy(id = "login-email")
    private WebElement loginEmailField;

    @FindBy(id = "login-password")
    private WebElement loginPasswordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(firstNameField);
    }

    /**
     * @param loginEmail WebElement with user login.
     * @param loginPassword  WebElement with user password.
     * @return HomePage loaded
     */
    public HomePage loginFormFillAndSubmit(String loginEmail, String loginPassword) {
        loginEmailField.sendKeys(loginEmail);
        loginPasswordField.sendKeys(loginPassword);
        signInButton.click();
        return new HomePage(driver);
    }

    /**
     * Completes registration form
     * @param firstName WebElement with user name.
     * @param lastName WebElement with user last name.
     * @param email WebElement with user email.
     * @param password WebElement with user password.
     */
    public void registrationFormFillAndSubmit(String firstName, String lastName, String email, String password ) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        joinNowButton.click();
    }

    /**
     * Gets message with error.
     * @return String with expected error text.
     */
    public String getErrorMessageText() {
        return errorMessageBox.getText();
    }
}
