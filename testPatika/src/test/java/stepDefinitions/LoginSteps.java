package stepDefinitions;

import Driver.DriverManager;
import pages.LoginPage;
import pages.DashboardPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    WebDriver driver = DriverManager.getDriver();

    // valid login steps: ..............................................................................................

    @Given("User is on the login page")
    public void user_on_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // to observe the dashboard page
        loginPage = new LoginPage(driver);
    }

    @When("User enter valid username {string} and password {string}")
    public void user_enter_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        System.out.println("Send valid username and password: " +username+" and "+password);
    }

    @And("User submit the login form")
    public void user_submit_the_login_form() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the dashboard page")
    public void user_should_be_redirected_to_the_dashboard_page() {
        dashboardPage = new DashboardPage(driver);
        String expectedTitle = "Dashboard";
        String actualTitle = dashboardPage.getPageTitle();
        System.out.println("User get Dashboard page title: " + dashboardPage.getPageTitle());
        assertEquals(expectedTitle, actualTitle);
    }

    // invalid login steps: ............................................................................................

    @When("User enter invalid username {string} and password {string}")
    public void user_enter_invalid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        System.out.println("Send invalid username and password: " +username+" and "+password);
    }

    @Then("User see the error message")
    public void user_see_the_error_message() {
    loginPage.assertingLoginErrorMessage();
    }

}

