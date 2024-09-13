// Abstract Class:

// An abstract class is a class that cannot be instantiated and may contain abstract methods (methods without implementation) as well as concrete methods (methods with implementation).
// It is used to represent shared behavior and can partially implement some functionality.

//An abstract class can be used to create a common base class for different page objects in a test framework, 
// where common methods (like initializing the WebDriver or navigating to a URL) are implemented, and abstract methods for page-specific actions are left to be implemented by subclasses.
// A class can only inherit from one abstract class. Abstract classes support single inheritance.

// Abstract Class Example:
// Let’s say we have an abstract class BasePage that provides common functionality for all page objects (like navigating to a URL, or setting up WebDriver).
// Each specific page class (e.g., LoginPage, HomePage) will extend this abstract class and implement any page-specific methods.


// BasePage.java
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    // Constructor to initialize the driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common method for all pages
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Abstract method: must be implemented by subclasses
    public abstract void waitForPageToLoad();
}

// LoginPage.java
public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Implementing the abstract method
    @Override
    public void waitForPageToLoad() {
        // Logic to wait for login page to load
        System.out.println("Waiting for Login page to load...");
    }

    // Additional LoginPage-specific method
    public void enterUsername(String username) {
        // Enter username logic
    }
}
