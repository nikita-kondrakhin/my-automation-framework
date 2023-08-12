package Pages;

import Base.BaseForm;
import Elements.Button;
import Elements.TableRow;
import Elements.TextField;
import Logger.LoggerManager;
import User.User;
import Forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesPage extends BaseForm {
    private final LoggerManager logger = new LoggerManager();

    private final Button addButton = new Button(By.id("addNewRecordButton"), "Add button");
    private final Form registrationForm = new Form(By.id("registration-form-modal"), "Registration form");
    private final TextField firstNameTextField = new TextField(By.id("firstName"), "First Name text field");
    private final TextField lastNameTextField = new TextField(By.id("lastName"), "Last Name text field");
    private final TextField emailTextField = new TextField(By.id("userEmail"), "Email text field");
    private final TextField ageTextField = new TextField(By.id("age"), "Age text field");
    private final TextField salaryTextField = new TextField(By.id("salary"), "Salary text field");
    private final TextField departmentTextField = new TextField(By.id("department"), "Department text field");
    private final Button submitButton = new Button(By.id("submit"), "Submit button");
    private final Button deleteButton4 = new Button(By.id("delete-record-4"), "Delete button for 4th row");
    private final TableRow tableRowWithData = new TableRow(By.xpath("//div[@class='action-buttons']"), "Table row with data");
    private final TableRow tableRow = new TableRow(By.xpath("//div[@class='rt-tr -even']"), "Table row");

    public WebTablesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Web Tables']"), "Web Tables page");
    }

    public void clickAddButton() {
        addButton.isPresented();
        addButton.moveToElementAndClick();
    }

    public void clickSubmitButton() {
        submitButton.isPresented();
        submitButton.click();
    }

    public void clickDeleteButton() {
        deleteButton4.isPresented();
        deleteButton4.scrollToElement();
        deleteButton4.moveToElementAndClick();
    }

    public boolean isRegistrationFormVisible() {
        return registrationForm.isVisible();
    }

    public void enterUserData(User user) {
        firstNameTextField.enterText(user.getFirstName());
        lastNameTextField.enterText(user.getLastName());
        emailTextField.enterText(user.getEmail());
        ageTextField.enterText(String.valueOf(user.getAge()));
        salaryTextField.enterText(String.valueOf(user.getSalary()));
        departmentTextField.enterText(user.getDepartment());
    }

    public int getTableRecordCount() {
        logger.debug("Getting table records count");
        List<WebElement> rows = tableRowWithData.getElements();
        return rows.size();
    }

    public boolean verifyInputUserInTable(User user) {
        List<WebElement> tableRows = tableRow.getElements();
        boolean userFound = false;
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.xpath("//div[@role='gridcell']"));
            if (cells.get(21).getText().equals(user.getFirstName())
                    && cells.get(22).getText().equals(user.getLastName())
                    && cells.get(23).getText().equals(String.valueOf(user.getAge()))
                    && cells.get(24).getText().equals(user.getEmail())
                    && cells.get(25).getText().equals(String.valueOf(user.getSalary()))
                    && cells.get(26).getText().equals(user.getDepartment())) {
                userFound = true;
                break;
            }
        }
        return userFound;
    }
}