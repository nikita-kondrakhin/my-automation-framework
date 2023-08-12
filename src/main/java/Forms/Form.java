package Forms;

import Base.BaseForm;
import org.openqa.selenium.By;

public class Form extends BaseForm {
    public Form(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }
}
