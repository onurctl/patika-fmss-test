package stepDefinitions;

import Driver.DriverManager;
import io.cucumber.java.Before;
import pages.LoginPage;
import pages.DashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.*;

public class SearchSteps {
    WebDriver driver = DriverManager.getDriver();
    private DashboardPage dashboardPage;

    @Before
    public void setUp() {
        dashboardPage = new DashboardPage(driver);
    }

    // search 1 steps: .................................................................................................

    @When("User click the Time button")
    public void user_click_time_button() {
        dashboardPage.clickTimeButton();
    }

    @When("User enter employee name {string} on the Time page")
    public void user_enter_employee_name_on_time_page(String employeeNameForTimesheet) {
        dashboardPage.searchNameForTimeSheet(employeeNameForTimesheet);
        System.out.println("Send employee name: "+employeeNameForTimesheet);
    }

    @When("User click the View Button on Time Page")
    public void user_click_the_view_button_on_time_page() {
        dashboardPage.clickTimeSheetViewButton();
    }

    @Then("User see the error message on Time page")
    public void user_see_error_message_on_time_page() {
        dashboardPage.assertingErrorMessageForTimeSheet();
    }

    // search 2 steps: .................................................................................................

    @When("User click the Admin button")
    public void user_click_admin_button() {
        dashboardPage.clickAdminButton();
    }

    @And("User enter username {string} on the Admin Page")
    public void i_enter_search_text_on_admin_page(String usernameForAdmin) {
        dashboardPage.searchNameForAdmin(usernameForAdmin);
        System.out.println("Send username: " + usernameForAdmin);
    }

    @When("User click the Search button on Admin Page")
    public void user_click_search_button_on_admin_page() {
        dashboardPage.clickAdminSearchButton();
    }

    @Then("User see the search results with the name of {string} on Admin Page")
    public void user_see_search_results_on_admin_page(String expectedNameForAdminSearch) {
        String actualName = dashboardPage.getAdminSearchResultsName();
        System.out.println("Username from actual result: " + dashboardPage.getAdminSearchResultsName());
        assertEquals(expectedNameForAdminSearch, actualName);
    }

    // search 3 steps: .................................................................................................

    @When("User search for {string} on the Side Panel")
    public void user_search_text_on_side_panel (String searchTermOnSidePanel) {
        dashboardPage.searchTextInSidePanel(searchTermOnSidePanel);
        System.out.println("Search term: " + searchTermOnSidePanel);
    }

    @Then("User should see {int} results on Side Panel")
    public void user_should_see_results_count_containing_search_text_on_side_panel (int expectedCount) {
        int actualCount = dashboardPage.getSearchResultsCount();
        System.out.println("Actual count: " + actualCount);
        assertEquals(expectedCount, actualCount);
    }

    // search 4 steps: .................................................................................................

    @Then("User should see the {string} on the Side Panel")
    public void user_should_see_full_text_search_results_on_side_panel(String expectedResult) {
        String actualResult = dashboardPage.getSidePanelFullTextSearchResult();
        System.out.println("Actual result: " + actualResult);
        assertEquals(expectedResult, actualResult);
    }

    // search 5 steps: .................................................................................................

    @When("User click Directory Button")
    public void user_click_directory_button() {
        dashboardPage.clickDirectoryButton();
    }

    @And("User choose an option {string} from the dropdown menu and click Search button on the Directory Page")
    public void user_choose_option_from_dropdown_and_click_search_button_on_directory_page(String selectedDropdownOptionOnDirectoryPage) {
        System.out.println("Option to select: " + selectedDropdownOptionOnDirectoryPage);
        dashboardPage.clickSearchButtonInDirectory();
    }

    @Then("User should see the result {string} on Directory Page")
    public void user_should_see_search_results_on_directory_page(String expectedDirectoryPageResultTitle) {
        String directoryResultsTitle = dashboardPage.getDirectoryResultsTitle();
        System.out.println("Actual result: " + directoryResultsTitle);
        assertTrue(directoryResultsTitle.contains(expectedDirectoryPageResultTitle));
    }

    // search 6 steps: .................................................................................................

    @When("User click the Recruitment button")
    public void user_click_recruitment_button() {
        dashboardPage.clickRecruitmentButton();
    }

    @When("User click the Search button on Recruitment Page")
    public void user_click_search_button_on_recruitment_page() {
        dashboardPage.clickRecruitmentSearchButton();
    }

    @Then("Use see the total number {string} of results on the Recruitment page")
    public void user_see_total_number_of_recruitment_search_results(String expectedResultCountOnRecruitmentPge) {
        String recruitmentResultsTitle = dashboardPage.getRecruitmentsResultsTitle();
        System.out.println("Actual result: " + recruitmentResultsTitle);
        assertTrue(recruitmentResultsTitle.contains(expectedResultCountOnRecruitmentPge));
    }

    // search 7 steps: .................................................................................................

    @When("User click the PIM button")
    public void user_click_pim_button() {
        dashboardPage.clickPIMButton();
    }

    @And("User enter ID {string} on PIM Page")
    public void user_enter_id_on_pim_page(String employeeID) {
        System.out.println("Enter ID: " + employeeID);
        dashboardPage.searchIDForEmployee(employeeID);
    }

    @When("User click the Employee Search button on PIM page")
    public void user_click_employee_search_button_pim_page() {
        dashboardPage.clickEmployeeSearchButton();
    }

    @Then("User see the PIM search results")
    public void user_see_pim_search_results() {
        String employeePIMResultsContent = dashboardPage.getPIMResultsContent();
        System.out.println(dashboardPage.getPIMResultsContent());
        assertFalse(employeePIMResultsContent.contains("o012"));
    }

}
