package Pages;

import Base.BaseForm;
import Elements.Iframe;
import Elements.Text;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
    private final Iframe nestedParentFrame = new Iframe(By.id("frame1"), "Nested parent frame");
    private final Text nestedParentFrameText = new Text(By.xpath("//body"), "Nested parent frame text");
    private final Iframe nestedChildFrame = new Iframe(By.cssSelector("iframe[srcdoc='<p>Child Iframe</p>']"), "Nested child frame");
    private final Text nestedChildFrameText = new Text(By.xpath("//p[normalize-space()='Child Iframe']"), "Nested child frame text");

    public NestedFramesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Nested Frames']"), "Nested frames page");
    }

    public void switchToDefaultContent() {
        Iframe.switchToDefaultContent();
    }

    public String getNestedParentFrameText() {
        nestedParentFrame.isPresented();
        nestedParentFrame.switchToIframe();
        nestedParentFrameText.isPresented();
        return nestedParentFrameText.getText();
    }

    public String getNestedChildFrameText() {
        nestedChildFrame.isPresented();
        nestedChildFrame.switchToIframe();
        nestedChildFrameText.isPresented();
        return nestedChildFrameText.getText();
    }
}
