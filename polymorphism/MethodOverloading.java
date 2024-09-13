// Method Overloading (Compile-time Polymorphism)
// In method overloading, multiple methods can have the same name but with different parameter types or parameter counts. 
// The method to be invoked is determined at compile-time based on the method signature.

// Example in Test Automation:
// You might overload methods for different types of input data or actions.
// Let's create a LoginPage class that allows users to log in with a username and password, and we overload the login() method to handle different login scenarios.

// LoginPage.java
public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method overloading: login() with different signatures
    
    // Login using username and password
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Login with only username, assuming default password
    public void login(String username) {
        String defaultPassword = "defaultPassword";
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(defaultPassword);
        driver.findElement(loginButton).click();
    }

    // Login with username, password and a security token
    public void login(String username, String password, String token) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(By.id("tokenField")).sendKeys(token); // Assuming token field exists
        driver.findElement(loginButton).click();
    }
}


//Test Case Usage:

// LoginTest.java
public class LoginTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void testLoginWithUsernameAndPassword() {
        loginPage.login("user1", "password123"); // Calls first login() method
    }

    @Test
    public void testLoginWithDefaultPassword() {
        loginPage.login("user2"); // Calls second login() method
    }

    @Test
    public void testLoginWithSecurityToken() {
        loginPage.login("user3", "password456", "123456"); // Calls third login() method
    }
}

// In this example, the method login() is overloaded three times to handle different login scenarios. 
// The compiler decides which method to invoke based on the number of arguments and their types.
