package Pages;

import Base.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {
    public SamplePage() {
        super(By.id("sampleHeading"), "Sample page");
    }
}
