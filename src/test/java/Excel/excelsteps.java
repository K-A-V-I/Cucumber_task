package Excel;

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

public class excelsteps {

    private WebDriver driver;
    private String username;
    private String password;

    @Given("User is on SignIn page")
    public void iNavigateToGmailLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
    }

  /*  @When("User enters sheet name {string} and row number {int} from Excel")
    public void userEntersSheetNameAndRowNumberFromExcel(String sheetName, int rowNumber) {
        System.out.println("Sheet Name: " + sheetName);  

        String excelFilePath = "src/test/resources/Exceldata/login.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                throw new RuntimeException("Row not found: " + rowNumber);
            }

            username = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    
   /* @When("User enters sheet name {string} and row number {int} from Excel")
    public void userEntersSheetNameAndRowNumberFromExcel(String sheetName, int rowNumber) {
        String excelFilePath = "src/test/resources/Exceldata/login.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);

            username = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();
            
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    
    
    @When("User enters sheet number {int} and row number {int} from Excel")
    public void iEnterGmailUsernameAndPasswordFromExcel(int sheetNumber, int rowNumber) {
        String excelFilePath = "src/test/resources/Exceldata/login.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetNumber);
            Row row = sheet.getRow(rowNumber);

            username = row.getCell(0).getStringCellValue();
            password = row.getCell(1).getStringCellValue();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("User clicks on login button")
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