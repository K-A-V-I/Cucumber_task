package naukri;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class naukristepdef {
    private WebDriver driver;

    @Given("I am on the Naukri homepage")
    public void iAmOnNaukriHomepage() {
    	System.setProperty("webdriver.chrome.driver", "C://Users/kavi1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe/");
        driver = new ChromeDriver(); 
        driver.get("https://www.naukri.com/");
    }

    @When("I search for {string} jobs")
    public void iSearchForJobsInLocation(String jobTitle) {
        WebElement jobTitleInput = driver.findElement(By.className("suggestor-input "));

        jobTitleInput.sendKeys(jobTitle);
         driver.findElement(By.className("qsbSubmit")).click();
         System.out.println("submittng");
    }

    @Then("I should see job search results")
    public void iShouldSeeJobSearchResults() throws InterruptedException {
    	Thread.sleep(3000);
        String pageTitle = driver.getTitle();

        WebElement result = driver.findElement(By.className("all-filters"));
        System.out.println("pagetitle"+pageTitle);
        System.out.println("result"+result);
        driver.quit();
    }
 
      
}