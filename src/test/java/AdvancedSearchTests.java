import org.testng.Assert;
import org.testng.annotations.*;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

    public class AdvancedSearchTests extends BaseTest {
    public HomePage homePage;

    /**
     * Displays the home page indicating that a user is logged in.
     */
    @BeforeClass
    public void beforeTest() {
        LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
        homePage = registrationPage.loginFormFillAndSubmit("selena1388@mail.ru", "123654A");
        Assert.assertTrue(homePage.isPageLoaded());
    }


    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData() {
        return new Object[][]{
                {"HR", "HR"},
                {"hr", "hr"},
        };
    }

    /**
     * Verifies searching for term submitted on advanced search.
     * @param searchTerm Text value that is entered when searching.
     * @param expectedContainedTerm Expected search term after searching.
     */
    @Test(dataProvider = "searchTerms")
    public void advancedSearchTest(String searchTerm, String expectedContainedTerm) {
        SearchPage searchPage = homePage.clickAdvancedSearchLink();
        searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(searchPage.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong");
        Assert.assertTrue(searchPage.checkSearchTermForEachResultInList(expectedContainedTerm), "Expected search term is not found in results list");
    }
}











