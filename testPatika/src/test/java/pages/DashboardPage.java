package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class DashboardPage {
    private WebDriver driver;

    // search 1 elements: ..............................................................................................
    
    private By pageTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private By timeButton = By.xpath("//span[text()='Time']");
    private By searchBoxInTimeSheet = By.xpath("//input[@placeholder='Type for hints...']");
    @FindBy(xpath = "//span[text()='Invalid']")
    WebElement TimeSheetErrorMessage;
    private By TimeSheetViewButton = By.xpath("//button[@type='submit']");

    // search 2 elements: ..............................................................................................
    
    private By adminButton = By.xpath("//span[text()='Admin']");
    private By searchBoxInAdminPage = By.xpath("(//input[@data-v-1f99f73c and contains(@class, 'oxd-input oxd-input--active')])[2]");
    private By adminSearchButton = By.xpath("(//button[@type='submit'])[1]");
    private By nameFromSearchResults = By.xpath("(//div[@data-v-6c07a142])[1]"); // en az bir, ilkine bak

    // search 3 elements: ..............................................................................................
    
    private By sidePanelSearchBox = By.xpath("//input[@placeholder='Search']");
    private By searchResultsInSidePanel = By.xpath("//div[@class='oxd-sidepanel-body']//li[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'a')]");

    // search 5 elements: ..............................................................................................
    
    private By directoryButton = By.xpath("//span[text()='Directory']");
    private By dropdownButton = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
    private By dropdownOption = By.xpath("//span[text()='New York Sales Office']");
    private By searchInDirectoryButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary') and contains(@class, 'orangehrm-left-space')]");
    private By DirectorySearchResultTitle = By.xpath("//span[@class='oxd-text oxd-text--span']");

    // search 4 elements: ..............................................................................................
    
    private By fullTextSearchResultInSidePanel = By.xpath("//div[@class='oxd-sidepanel-body']");

    // search 6 elements: ..............................................................................................
    
    private By recruitmentButton = By.xpath("//span[text()='Recruitment']");
    private By recruitmentSearchButton = By.xpath("(//button[@type='submit'])[1]");
    private By titleFromRecruitmentSearchResults = By.xpath("//span[@class='oxd-text oxd-text--span']");

    // search 7 elements: ..............................................................................................
    
    private By pimButton = By.xpath("//span[text()='PIM']");
    private By idSearchBoxInPIMPage = By.xpath("(//input[@data-v-1f99f73c='' and @class='oxd-input oxd-input--active'])[2]");
    private By employeePIMSearchButton = By.xpath("(//button[@type='submit'])[1]");
    private By contentFromPIMSearchResults = By.xpath("//div[@class='orangehrm-container']");

    // dashboard page functionality: ...................................................................................
    
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Findby kullanılırsa gerekli
    }

    // after valid login functions: ....................................................................................
    
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // search 1 functions: .............................................................................................
    
    public void clickTimeButton() {
        driver.findElement(timeButton).click();
    }
    public void searchNameForTimeSheet(String nameForTimeSheet) {
        driver.findElement(searchBoxInTimeSheet).sendKeys(nameForTimeSheet);
    }
    public void clickTimeSheetViewButton() {
        driver.findElement(TimeSheetViewButton).click();
    }
    public void assertingErrorMessageForTimeSheet(){
        assertTrue(TimeSheetErrorMessage.getText().contains("Invalid"));
        System.out.println("Error message on Time page: " + TimeSheetErrorMessage.getText());
    }

    // search 2 functions: .............................................................................................
    
    public void clickAdminButton() {
        driver.findElement(adminButton).click();
    }
    public void searchNameForAdmin(String nameForAdmin) {
        driver.findElement(searchBoxInAdminPage).sendKeys(nameForAdmin);
    }
    public void clickAdminSearchButton() {
        driver.findElement(adminSearchButton).click();
    }
    public String getAdminSearchResultsName() {
        return driver.findElement(nameFromSearchResults).getText();
    }

    // search 3 functions: .............................................................................................
    
    public void searchTextInSidePanel(String searchTerm){
        driver.findElement(sidePanelSearchBox).sendKeys(searchTerm);
    }
    public int getSearchResultsCount() {
        List<WebElement> searchResults = driver.findElements(searchResultsInSidePanel);
        return searchResults.size();
    }

    // search 5 functions: .............................................................................................
    
    public void clickDirectoryButton() {
        driver.findElement(directoryButton).click();
    }
    public void clickSearchButtonInDirectory() {
        driver.findElement(dropdownButton).click();
        driver.findElement(dropdownOption).click();
        driver.findElement(searchInDirectoryButton).click();
    }
    public String getDirectoryResultsTitle() {
        return driver.findElement(DirectorySearchResultTitle).getText();
    }

    // search 4 functions: .............................................................................................
    
    public String getSidePanelFullTextSearchResult() {
        return driver.findElement(fullTextSearchResultInSidePanel).getText();
    }

    // search 6 functions: .............................................................................................
    
    public void clickRecruitmentButton() {
        driver.findElement(recruitmentButton).click();
    }
    public void clickRecruitmentSearchButton() {
        driver.findElement(recruitmentSearchButton).click();
    }
    public String getRecruitmentsResultsTitle() {
        return driver.findElement(titleFromRecruitmentSearchResults).getText();
    }

    // search 7 functions: .............................................................................................
    
    public void clickPIMButton() {
        driver.findElement(pimButton).click();
    }
    public void searchIDForEmployee(String keyword) {
        driver.findElement(idSearchBoxInPIMPage).sendKeys(keyword);
    }
    public void clickEmployeeSearchButton() {
        driver.findElement(employeePIMSearchButton).click();
    }
    public String getPIMResultsContent() {
        return driver.findElement(contentFromPIMSearchResults).getText();
    }

}

