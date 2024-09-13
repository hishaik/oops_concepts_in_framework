// Method Overriding (Runtime Polymorphism)
// In method overriding, a subclass provides a specific implementation of a method that is already defined in its superclass.
// The method to be executed is determined at runtime based on the object's actual type.

// Example in Test Automation:
// You may want to customize browser setup for different browsers (Chrome, Firefox) by overriding a method in a base class that handles WebDriver setup.

//------------------------------------//

// BaseTest.java (Superclass)
public class BaseTest {
    protected WebDriver driver;

    // Method to be overridden in subclasses
    public WebDriver setUpDriver() {
        System.out.println("Setting up WebDriver...");
        driver = new ChromeDriver(); // Default to Chrome
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing WebDriver...");
        if (driver != null) {
            driver.quit();
        }
    }
}

// ChromeTest.java (Subclass overriding method)
public class ChromeTest extends BaseTest {
    @Override
    public WebDriver setUpDriver() {
        System.out.println("Setting up ChromeDriver...");
        driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void testChrome() {
        driver.get("https://example.com");
        // Test logic for Chrome
    }
}

// FirefoxTest.java (Subclass overriding method)
public class FirefoxTest extends BaseTest {
    @Override
    public WebDriver setUpDriver() {
        System.out.println("Setting up FirefoxDriver...");
        driver = new FirefoxDriver();
        return driver;
    }

    @Test
    public void testFirefox() {
        driver.get("https://example.com");
        // Test logic for Firefox
    }
}


//Test Case Usages

// TestRunner.java
public class TestRunner {
    public static void main(String[] args) {
        BaseTest testChrome = new ChromeTest();
        testChrome.setUpDriver(); // Calls overridden method in ChromeTest

        BaseTest testFirefox = new FirefoxTest();
        testFirefox.setUpDriver(); // Calls overridden method in FirefoxTest
    }
}

// In this example:
// The BaseTest class defines a method setUpDriver().
// The ChromeTest and FirefoxTest classes override this method to provide browser-specific setup.
// At runtime, the appropriate method is called based on the object type (ChromeTest or FirefoxTest).
