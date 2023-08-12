package Pages;

import Base.BaseForm;
import Elements.Button;
import Logger.LoggerManager;
import org.openqa.selenium.By;


public class MainPage extends BaseForm {
    private final LoggerManager logger = new LoggerManager();

    private final Button afwButton = new Button(By.xpath("//div[@class='card mt-4 top-card'][3]"), "Alerts, Frames and Windows button");
    private final Button alertsButton = new Button(By.xpath("//span[text()='Alerts']//parent::li"), "Alerts button");
    private final Button nestedFramesButton = new Button(By.xpath("//span[text()='Nested Frames']//parent::li"), "Nested Frames button");
    private final Button framesButton = new Button(By.xpath("//span[text()='Frames']//parent::li"), "Frames button");
    private final Button browserWindowsButton = new Button(By.xpath("//span[text()='Browser Windows']//parent::li"), "Browser Windows button");
    private final Button elementsButton = new Button(By.xpath("//div[@class='card mt-4 top-card'][1]"), "Elements button");
    private final Button elementsButtonAccordion = new Button(By.xpath("//div[@class='element-group'][1]"), "Elements button (accordion)");
    private final Button linksButton = new Button(By.xpath("//span[text()='Links']//parent::li"), "Links button");
    private final Button webTablesButton = new Button(By.xpath("//span[text()='Web Tables']//parent::li"), "Web Tables button");

    public MainPage() {
        super(By.xpath("//img[@class='banner-image']"), "Main page");
    }

    public void openAlertsFramesAndWindowsPage() {
        logger.debug("Opening Alerts, Frames and Windows page");
        afwButton.isPresented();
        afwButton.scrollToElement();
        afwButton.click();
    }

    public void openAlertsPage() {
        logger.debug("Opening Alerts page");
        alertsButton.isPresented();
        alertsButton.scrollToElement();
        alertsButton.click();
    }

    public void openNestedFramesPage() {
        logger.debug("Opening Nested Frames page");
        nestedFramesButton.isPresented();
        nestedFramesButton.scrollToElement();
        nestedFramesButton.click();
    }

    public void openFramesPage() {
        logger.debug("Opening Frames page");
        framesButton.isPresented();
        framesButton.scrollToElement();
        framesButton.click();
    }

    public void openBrowserWindowsPage() {
        logger.debug("Opening Browser Windows page");
        browserWindowsButton.isPresented();
        browserWindowsButton.scrollToElement();
        browserWindowsButton.click();
    }

    public void openLinksPage() {
        logger.debug("Opening Links page");
        elementsButtonAccordion.isPresented();
        elementsButtonAccordion.scrollToElement();
        elementsButtonAccordion.click();
        linksButton.isPresented();
        linksButton.scrollToElement();
        linksButton.click();
    }

    public void openWebTablesPage() {
        logger.debug("Opening Web Tables page");
        elementsButton.isPresented();
        elementsButton.scrollToElement();
        elementsButton.click();
        webTablesButton.isPresented();
        webTablesButton.scrollToElement();
        webTablesButton.click();
    }
}
