package hooks;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class hooksstep {
 
    WebDriver driver;
    private String username;
    private String password;
    @Before
    public void setup() {
 
        System.out.println("---------------------Before Executing----------------------");
        System.setProperty("webdriver.chrome.driver", "C://Users/kavi1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe/");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 
    @BeforeStep
    public void beforeStepTest() {
        System.out.println("--------------BeforeStep Executing---------------");
    }
 
    @Given("User is on Home page")
    public void userOnHomePage() {
 
        System.out.println("Open Website");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
 
    @When("User enters username as {string}")
    public void entersUsername(String userName) throws InterruptedException {
 
         username = userName;
        WebElement user =driver.findElement(By.name("txtUsername"));
        user.sendKeys(userName);
        System.out.println("Enter userName" +userName);
    }
 
    @When("User enters password as {string}")
    public void entersPassword(String passWord) throws InterruptedException {
 
        System.out.println("Enter passWord");
        WebElement pass =driver.findElement(By.name("txtPassword"));
        pass.sendKeys(passWord);
 
        driver.findElement(By.id("btnLogin")).submit();
    }
 
    @Then("User should be able to login sucessfully")
    public void sucessfullLogin() throws InterruptedException {
 
        String newPageText = driver.findElement(By.id("welcome")).getText();
        System.out.println("newPageText:" + newPageText);
        assertThat(newPageText, containsString("Welcome"));
 
    }
 
    @AfterStep
    public void afterStepTest() {
        System.out.println("--------------------AfterStep Executing---------------------");
    }
 
    @After
    public void close() {
        driver.close();
        System.out.println("--------------------After Executing----------------------");
    }
}