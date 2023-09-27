package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class amazonstepdef {

    private WebDriver driver;

    @Given("I am on the e-commerce website")
    public void i_am_on_the_e_commerce_website() {
     
        System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
    }

    @When("I log in with {string} and {string}")
    public void i_log_in_with_username_and_password(String username, String password) {
     
        WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
        signInButton.click();

    
        WebElement usernameField = driver.findElement(By.id("ap_email"));
        usernameField.sendKeys(username);
        WebElement continueButton = driver.findElement(By.id("continue"));  
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("signInSubmit"));
        loginButton.click();
    }
    @When("I add a laptop to the cart")
    public void i_add_a_laptop_to_the_cart() {
    	 WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
         searchBox.sendKeys("Laptop");
         searchBox.submit();
        WebElement laptop = driver.findElement(By.className("s-image"));
        laptop.click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }
    
    
    @When("I search for a {string}")
    public void i_search_for_a_product(String product) {
        // Find the search box and enter the product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    @Then("I should see search results for laptops")
    public void i_should_see_search_results() {
        System.out.println("Search results page title: " + driver.getTitle());
    }

  
    @Then("I close the browser")
    public void i_close_the_browser() {
      
            driver.quit();
        
    }
}
