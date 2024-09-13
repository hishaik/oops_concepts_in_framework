// Inheritance in a Test Framework
// Inheritance allows a class to inherit properties and methods from another class. In a test automation framework, this is useful when you have common methods or configurations that can be reused across multiple test classes.

// Example:
// You could have a BaseTest class that sets up the WebDriver, which is then inherited by all your test classes to avoid duplicating setup and teardown code.

// BaseTest.java
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing WebDriver...");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing WebDriver...");
        driver.quit();
    }
}

// LoginTest.java
public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        driver.get("https://example.com/login");
        // Test steps to login
    }
}

// SearchTest.java
public class SearchTest extends BaseTest {
    @Test
    public void testSearch() {
        driver.get("https://example.com/search");
        // Test steps to search
    }
}


// LoginTest and SearchTest inherit the setup and teardown methods from BaseTest, avoiding redundancy.
