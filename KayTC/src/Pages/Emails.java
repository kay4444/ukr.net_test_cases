package Pages;
import Elements.Button;
import Enums.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static MainSettings.Settings.getDriver;
/**
 * Created by serhii.kaihorodov on 1/15/2016.
 */
public class Emails {
private Button write_letter = new Button(By.xpath(Variables.WRITE_LETTER_BUTTON.toString()));
private WebElement next_page_is_disabled = null;
private Button next_page = next_page = new Button (By.xpath(Variables.NEXT_PAGE.toString()));

    public Emails select_check_boxes_for_some_emails() {
        OUTERMOST: for (int i = 0; i < 1000; i++) {
            List<WebElement> check_boxes = getDriver().findElements(By.xpath(Variables.CHECK_BOXES_OF_EMAILS.toString()));
            List<WebElement> emails_sender = getDriver().findElements(By.xpath(Variables.EMAILS_SENDER_FIELD.toString()));
            int s = check_boxes.size();
            Boolean bul = null;
            if (!check_boxes.get(s - 1).isSelected()) {
                for (WebElement ell : emails_sender) {
                    int ii = emails_sender.indexOf(ell);
                    if (ell.getText().equals("Facebook")) {
                        if (!check_boxes.get(ii).isSelected()) {
                            check_boxes.get(ii).click();
                        }
                    }
                }
            }
            else {
                break OUTERMOST;
            }
            try {
                next_page_is_disabled = getDriver().findElement(By.xpath(Variables.DISABLED_NEX_BUTTON.toString()));
            }
            catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("NoSuchElementException exception is handled. The next line is Stack Trace of this exception");
                e.printStackTrace();
            }
            try {
                bul = next_page_is_disabled.isDisplayed();
            }
            catch (java.lang.NullPointerException e) {
                System.out.println("java.lang.NullPointerException exception has been handled successfully");
                e.printStackTrace();
            }
            if (bul == Boolean.TRUE) {
                break;
            }
            else {
                next_page.click();
            }
        }
        return new Emails();
    }
}
