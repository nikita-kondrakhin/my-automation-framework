package Tests;

import Base.BaseTest;
import Logger.LoggerManager;
import Pages.AlertsPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
    private final LoggerManager logger = new LoggerManager();
    MainPage mainPage = new MainPage();
    AlertsPage alertsPage = new AlertsPage();

    @Test
    public void alertsTest() {
        logger.info("Running " + this.getClass().toString() + ":");

        mainPage.openMainPage();
        Assert.assertTrue(mainPage.isOpen(), "Wrong page. Main page should be opened");
        mainPage.openAlertsFramesAndWindowsPage();
        mainPage.openAlertsPage();
        Assert.assertTrue(alertsPage.isAlertsFormVisible(), "Alerts form doesn't appeared on page");
        alertsPage.clickButtonToSeeAlert();
        Assert.assertTrue(alertsPage.isAlertOpen(), "Alert with text \"You clicked a button\" doesn't open");
        alertsPage.alertAccept();
        Assert.assertFalse(alertsPage.isAlertOpen(), "Alert with text \"You clicked a button\" hasn't been closed");
        alertsPage.clickConfirmBoxButton();
        Assert.assertTrue(alertsPage.isAlertOpen(), "Alert with text \"Do you confirm action?\" doesn't open");
        alertsPage.alertAccept();
        Assert.assertFalse(alertsPage.isAlertOpen(), "Alert with text \"Do you confirm action?\" hasn't been closed");
        Assert.assertEquals(alertsPage.getConfirmBoxAlertAppearedText(), "You selected Ok", "Wrong text appeared on the page, should be \"You selected Ok\"");
        alertsPage.clickPromptBoxButton();
        Assert.assertTrue(alertsPage.isAlertOpen(), "Alert with text \"Please enter your name\" doesn't open");
        String alertRandomText = alertsPage.randomText();
        alertsPage.alertRandomTextInput(alertRandomText);
        alertsPage.alertAccept();
        Assert.assertFalse(alertsPage.isAlertOpen(), "Alert with text \"Please enter your name\" hasn't been closed");
        Assert.assertEquals(alertsPage.getPromptBoxAlertAppearedText(), "You entered " + alertRandomText, "Appeared text does not equals to the text entered before");
    }
}
