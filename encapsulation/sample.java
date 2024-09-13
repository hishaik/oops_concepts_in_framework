// Key Aspects of Encapsulation:
// Data Hiding: Fields (variables) of a class are hidden from other classes and can only be accessed via public methods.
// Getter and Setter Methods: Encapsulated data is accessed and modified through getter and setter methods rather than directly manipulating the fields.

// Scenario:
// We have a login page for a web application, and we want to encapsulate the web elements and their interactions so that they are not directly exposed. 
// We'll use private variables for web elements and provide public methods for interaction.


// LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Encapsulated web elements using private access modifier
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Public setter method to enter username (providing controlled access)
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Public setter method to enter password (providing controlled access)
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Public method to click the login button (providing controlled access)
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Public method to verify login success
    public boolean isLoginSuccessful() {
        return driver.findElement(By.id("welcomeMsg")).isDisplayed();
    }
}

//---------------------------------------------------------// 

// Test Case Using Encapsulation
// In the test case, instead of directly interacting with the web elements, we use the encapsulated methods (setUsername(), setPassword(), and clickLoginButton()). 
// This ensures that the internal details of the LoginPage class are hidden and only the necessary methods are exposed.

// LoginTest.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Setting up WebDriver (Chrome)
        driver = new ChromeDriver();
        driver.get("https://example.com/login");

        // Initializing the page object (LoginPage)
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        // Using encapsulated methods to interact with the page
        loginPage.setUsername("user1");
        loginPage.setPassword("password123");
        loginPage.clickLoginButton();

        // Verify login success
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

