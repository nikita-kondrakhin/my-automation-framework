package Pages;

import Base.BaseForm;
import Elements.Iframe;
import Elements.Text;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    private final Iframe upperFrame = new Iframe(By.id("frame1"), "Upper frame");
    private final Text upperFrameText = new Text(By.xpath("//h1[@id='sampleHeading']"), "Upper frame text");
    private final Iframe lowerFrame = new Iframe(By.id("frame2"), "Lower frame");
    private final Text lowerFrameText = new Text(By.xpath("//h1[@id='sampleHeading']"), "Lower frame text");

    public FramesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Frames']"), "Frames page");
    }

    public String getUpperFrameText() {
        upperFrame.isVisible();
        upperFrame.switchToIframe();
        upperFrameText.isVisible();
        return upperFrameText.getText();
    }

    public String getLowerFrameText() {
        lowerFrame.isVisible();
        lowerFrame.switchToIframe();
        lowerFrameText.isVisible();
        return lowerFrameText.getText();
    }

    public void switchToDefaultContent() {
        Iframe.switchToDefaultContent();
    }
}
