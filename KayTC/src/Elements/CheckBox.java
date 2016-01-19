package Elements;

import org.openqa.selenium.By;

/**
 * Created by serhii.kaihorodov on 1/15/2016.
 */
public class CheckBox extends Element
{

    public CheckBox(By by) {
        super(by);
    }

    public void click()
    {
        composeWebElement().click();
    }

    public boolean isChecked()
    {
        return composeWebElement().isSelected();
    }
}
