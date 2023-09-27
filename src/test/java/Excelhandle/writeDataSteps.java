package Excelhandle;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;

public class writeDataSteps {

    private WebDriver driver;
    private String username;
    private String password;

    @Given("I navigate to the Gmail login page")
    public void iNavigateToGmailLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
    }

    @When("I enter Gmail username and password from Excel")
    public void iEnterGmailUsernameAndPasswordFromExcel() {
        String excelFilePath = "src/test/resources/Exceldata/login.xlsx";
        int sheetIndex = 0; // Assuming data is in the first sheet
        try (FileInputStream fis = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(1); // Assuming data is in the first row
            username = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I click the Gmail login button")
    public void iClickGmailLoginButton() {
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(username);

        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
    }

    @Then("I should be logged into Gmail")
    public void iShouldBeLoggedInToGmail() {
        System.out.println("Move to password field");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id =\"password\"]/div[1]/div / div[1]/input")));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id =\"password\"]/div[1]/div / div[1]/input"));
        passwordField.sendKeys(password);

        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        nextButton.click();
    }
}
