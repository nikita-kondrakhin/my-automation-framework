package Pages;

import Base.BaseForm;
import Elements.Link;
import Util.BrowserUtil;
import org.openqa.selenium.By;

import java.util.Set;

public class LinksPage extends BaseForm {
    private final Link homeLink = new Link(By.id("simpleLink"), "Home link");

    public LinksPage() {
        super(By.xpath("//div[@class='main-header' and text()='Links']"), "Links page");
    }

    public void clickHomeLink() {
        homeLink.isPresented();
        homeLink.click();
    }

    public String getCurrentWindowHandle() {
        return BrowserUtil.getCurrentWindowHandle();
    }

    public Set<String> getCurrentWindowHandles() {
        return BrowserUtil.getCurrentHandles();
    }

    public void switchToTheNewWindow(String currentWindowHandle, Set<String> windowHandles) {
        BrowserUtil.switchToTheNewWindow(currentWindowHandle, windowHandles);
    }

    public void switchToSpecificWindow(String windowHandle) {
        BrowserUtil.switchToSpecificWindow(windowHandle);
    }
}
