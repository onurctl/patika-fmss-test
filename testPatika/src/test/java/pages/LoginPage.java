package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // valid login elements: ...........................................................................................
    
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[contains(@class, 'oxd-input') and contains(@name, 'password')]");
    private By loginButton = By.xpath("//button[@type='submit']");

    // invalid login elements: .........................................................................................
    
    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    WebElement LoginErrorMessage;

    // login page functionality: .......................................................................................
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // valid login functions: ..........................................................................................
    
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // invalid login functions: ........................................................................................
    
    public void assertingLoginErrorMessage(){
        Assert.assertTrue(LoginErrorMessage.getText().contains("Invalid credentials"));
        System.out.println("User get error message:" + LoginErrorMessage.getText());
    }
}

