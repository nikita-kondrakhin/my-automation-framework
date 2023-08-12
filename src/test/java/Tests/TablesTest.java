package Tests;

import Base.BaseTest;
import Logger.LoggerManager;
import Pages.MainPage;
import Pages.WebTablesPage;
import User.User;
import User.UserManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TablesTest extends BaseTest {
    private final LoggerManager logger = new LoggerManager();
    MainPage mainPage = new MainPage();
    WebTablesPage webTablesPage = new WebTablesPage();

    @DataProvider(name = "User Data")
    public static Object[][] userData() {
        UserManager userManager = new UserManager();
        List<User> users = userManager.getUsers();

        Object[][] data = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }
        return data;
    }

    @Test(dataProvider = "User Data")
    public void tablesTest(User user) throws InterruptedException {
        logger.info("Running " + this.getClass().toString() + ":");

        mainPage.openMainPage();
        Assert.assertTrue(mainPage.isOpen(), "Wrong page. Main page should be opened");
        mainPage.openWebTablesPage();
        Assert.assertTrue(webTablesPage.isOpen(), "Wrong page. Web Tables page should be opened");
        webTablesPage.clickAddButton();
        Assert.assertTrue(webTablesPage.isRegistrationFormVisible(), "Registration form doesn't appeared on page");
        webTablesPage.enterUserData(user);
        webTablesPage.clickSubmitButton();
        Thread.sleep(1000);
        Assert.assertFalse(webTablesPage.isRegistrationFormVisible(), "Registration form has not been closed");
        Assert.assertTrue(webTablesPage.verifyInputUserInTable(user), "Data of User № has not appeared in table");
        int initialTableRecordCount = webTablesPage.getTableRecordCount();
        webTablesPage.clickDeleteButton();
        int updatedTableRecordCount = webTablesPage.getTableRecordCount();
        Assert.assertNotEquals(initialTableRecordCount, updatedTableRecordCount, "Input data of User № has not been deleted from table");
    }
}
