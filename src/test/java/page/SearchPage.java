package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class SearchPage extends BasePage {

    @FindBy(id = "advs")
    private WebElement advancedSearchForm;

    @FindBy(id = "advs-keywords")
    private WebElement keywordField;

    @FindBy(xpath = "//div[@class='description']")
    private List<WebElement> searchResultsDescriptionsList;

    @FindBy(xpath = "//div[@class='search-info']/p[contains(text(), 'results for') or contains(text(), 'результатов для')]")
    private WebElement resultsForInfoText;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitUntilElementDisplayed(advancedSearchForm);
    }

    /**
     * Displays the result for search term submitted
     * @param searchTerm Text value that is entered when searching
     */
    public void fillKeywordSearchTermAndSubmit(String searchTerm) {
        waitUntilElementDisplayed(keywordField).clear();
        keywordField.sendKeys(searchTerm);
        keywordField.submit();
        waitUntilElementDisplayed(resultsForInfoText);
    }
    /**
     * Gets the number of results to be displayed on the page.
     * @return int that displays the result number on page.
     */
    public int getSearchResultsOnPageCount() {
        return searchResultsDescriptionsList.size();
    }

    /**
     * Gets a list of searchResults
     */
    public void getDescriptionStringList() {
        List<String> searchResultDescriptionStringList = new ArrayList<String>();
        for (WebElement searchResultsDescriptionElement : searchResultsDescriptionsList) {
            searchResultDescriptionStringList.add(searchResultsDescriptionElement.getText());
        }
    }

    /**
     * Verifies that each result in a list contains search term.
     */
    public boolean checkSearchTermForEachResultInList(String searchTerm) {
        for (int i = 0; i < searchResultsDescriptionsList.size(); i++) {
            searchResultsDescriptionsList.get(i).getText().contains(searchTerm);
            if (searchTerm != null && searchTerm.equals(searchResultsDescriptionsList)); {
                return true;
            }
        }
        return false;
    }
}

