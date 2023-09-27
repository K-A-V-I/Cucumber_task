package Excelhandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Excelstepdef {

    WebDriver driver;
    String baseUrl = "https://accounts.google.com/signin";

    @Given("I open the Gmail login page")
    public void i_open_the_Gmail_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @When("I enter valid username and password from Excel")
    public void i_enter_valid_username_and_password_from_Excel() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/Exceldata/login.xlsx")) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1); 

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            WebElement emailField = driver.findElement(By.id("identifierId"));
            emailField.sendKeys(username);

            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();
            
            WebDriverWait wait = new WebDriverWait(driver,30);
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id =\"password\"]/div[1]/div / div[1]/input")));
           WebElement passwordField = driver.findElement(By.xpath("//*[@id =\"password\"]/div[1]/div / div[1]/input"));
           passwordField.sendKeys(password);

           WebElement nextButton1 = driver.findElement(By.id("passwordNext"));
           nextButton1.click();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Your logic to assert successful login
        Assert.assertTrue(driver.getTitle().contains("Inbox"));

        driver.quit();
    }
}
