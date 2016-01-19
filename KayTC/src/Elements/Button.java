package Elements;

import org.openqa.selenium.By;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
public class Button extends Element
{
    public Button(By by)
    {
        super(by);
    }

    public void click()
    {
        composeWebElement().click();
    }


}
