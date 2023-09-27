package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class google {
	public static WebDriver driver = null;
	
@Given("User launch chrome browser")
public void user_lauch_chrome_broser() {
	System.out.println("Launching chrome...");
    System.setProperty("webdriver.chrome.driver", "C://Users/kavi1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe/");
    driver = new ChromeDriver();
	System.out.println("After Launching chrome...");
	driver.manage().window().maximize();
	driver.get("http://www.google.com");
}

@When("User enter bdd in search box")
public void User_enter_bdd_in_search_box() {
	  System.out.println("Entering search box...");
	    WebElement searchBox = driver.findElement(By.name("q")); 
	    searchBox.sendKeys("testing");
	
}
@When("User click on search button")
public void User_click_on_search_button() throws InterruptedException {
	WebElement searchButton = driver.findElement(By.name("btnK"));
	System.out.println("clicking in chrome..");
	Thread.sleep(2000);
	driver.close();
}
}
