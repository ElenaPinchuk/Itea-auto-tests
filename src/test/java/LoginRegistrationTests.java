import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

/**
 * Class with all Login and Registration tests
 */
public class LoginRegistrationTests extends BaseTest {

    @DataProvider(name = "errorMessages")
    public Object[][] errorMessagesTexts() {
        return new Object[][]{
                {"", "", "", "", "Please enter your first name"},
                {"Natali", "", "", "", "Please enter your last name"},
                {"Natali", "Smith", "", "", "Please enter your email address"},
                {"Natali", "Smith", "selena1388@mail.ru", "", "Please enter your password"}
        };
    }

    /**
     * Verifies error messages with empty registration fields submitted.
     * @param firstUserName Given name of a user.
     * @param lastUserName Family name of a user.
     * @param userEmail Registered user email.
     * @param userPassword Characters used for user authentication.
     * @param expectedErrorMessage Text that should be displayed to describe a problem.
     */
    @Test(dataProvider = "errorMessages")
    public void errorMessageOnEmptyFormSubmit(String firstUserName, String lastUserName, String userEmail, String userPassword, String expectedErrorMessage) {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        registrationPage.registrationFormFillAndSubmit(firstUserName, lastUserName, userEmail, userPassword);
        Assert.assertEquals(registrationPage.getErrorMessageText(), expectedErrorMessage, "Expected error message was not found on page");
    }

    /**
     * Loads HomePage after login with correct data
     */
    @Test
    public void successfulLoginTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = registrationPage.loginFormFillAndSubmit("selena1388@mail.ru", "123654A");
        Assert.assertTrue(homePage.isPageLoaded());
    }
}



