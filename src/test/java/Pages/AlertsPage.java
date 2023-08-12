package Pages;

import Base.BaseForm;
import Elements.Button;
import Elements.Text;
import Util.AlertsUtil;
import Forms.Form;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {
    private final Form alertsForm = new Form(By.id("javascriptAlertsWrapper"), "Alerts form");
    private final Button alertButton = new Button(By.id("alertButton"), "Alert button");
    private final Button confirmBoxButton = new Button(By.id("confirmButton"), "Confirm Box Button");
    private final Button promptBoxButton = new Button(By.id("promtButton"), "Prompt Box Button");
    private final Text appearedConfirmBoxTextElement = new Text(By.xpath("//span[@id='confirmResult']"), "Element with text \"You selected OK\"");
    private final Text appearedPromptBoxTextElement = new Text(By.xpath("//span[@id='promptResult']"), "Element with random text");

    public boolean isAlertsFormVisible() {
        return alertsForm.isVisible();
    }
    
    public boolean isAlertOpen() {
        return AlertsUtil.isAlertOpen();
    }
    
    public void clickButtonToSeeAlert() {
        alertButton.isPresented();
        alertButton.scrollToElement();
        alertButton.moveToElementAndClick();
    }

    public void clickConfirmBoxButton() {
        confirmBoxButton.isPresented();
        confirmBoxButton.scrollToElement();
        confirmBoxButton.moveToElementAndClick();
    }

    public void clickPromptBoxButton() {
        confirmBoxButton.isPresented();
        confirmBoxButton.scrollToElement();
        promptBoxButton.moveToElementAndClick();
    }
    
    public void alertAccept() {
        AlertsUtil.alertAccept();
    }

    public String getConfirmBoxAlertAppearedText() {
        return appearedConfirmBoxTextElement.getText();
    }

    public String getPromptBoxAlertAppearedText() {
        return appearedPromptBoxTextElement.getText();
    }

    public String randomText() {
        return Text.randomText();
    }
    
    public void alertRandomTextInput(String randomText) {
        AlertsUtil.alertRandomTextInput(randomText);
    }
}
