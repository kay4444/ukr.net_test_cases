package Elements;

import org.openqa.selenium.By;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
public class TextField extends Element
{
    public TextField(By by) {
        super(by);
    }

    public void enterText(String string)
    {
        composeWebElement().clear();
        composeWebElement().sendKeys(string);
    }
}
