package Pages;

import Elements.Button;
import Enums.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static MainSettings.Settings.getDriver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by serhii.kaihorodov on 1/5/2016.
 */
public class Edisk {
    private Button upload_files_little_button = new Button(By.xpath(Variables.UPLOAD_FILES_LITTLE_BUTTON.toString()));
    private Button upload_files_big_button = new Button (By.xpath(Variables.UPLOAD_FILES_BUTTON.toString()));
    private Button simple_version_of_files_uploading = new Button (By.xpath(Variables.SIMPLE_VERSION_OF_FILES_UPLOADING.toString()));
    private Button select_files_button = new Button(By.xpath(Variables.SELECT_FILES_BUTTON.toString()));
    private Button close_upload_files_pop_up = new Button(By.xpath(Variables.CLOSE_UPLOAD_FILES_POP_UP.toString()));
    private List<WebElement> list_of_uploaded_files = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));
    private List<WebElement> list_of_check_boxed_for_uploaded_files = getDriver().findElements(By.xpath(Variables.CHECK_BOXES_FOR_UPLOADED_FILES.toString()));
    private Button delete_button = new Button (By.xpath(Variables.DELETE_BUTTON.toString()));

    public Edisk upload_file_to_Edisk()
    {
        if (upload_files_big_button.isPresent())
        {
            upload_files_big_button.click();
        }
        else
        {
            upload_files_little_button.click();
        }

        simple_version_of_files_uploading.waitForElementIsPresent();
        simple_version_of_files_uploading.click();

        select_files_button.waitForElementIsPresent();
        select_files_button.click();

        try {
            Runtime.getRuntime().exec("D:\\Projects\\Upload_Files_For_ukr_net.exe");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        close_upload_files_pop_up.waitForElementIsPresent();
        close_upload_files_pop_up.click();

        List<WebElement> list_of_uploaded_files1 = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));

        assertFalse(list_of_uploaded_files1.isEmpty(), "TC is failed - there is no expected uploaded file");

        return new Edisk();
    }

    public Edisk delete_uploaded_files()
    {
        if (list_of_check_boxed_for_uploaded_files.isEmpty())
        {
            return new Edisk();
        }
        else
        {
            for (WebElement ell : list_of_check_boxed_for_uploaded_files)
            {
                ell.click();
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        delete_button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
// How to handle javascript alerts - please see "http://www.seleniumeasy.com/selenium-tutorials/how-to-handle-javascript-alerts-confirmation-prompts" link
        org.openqa.selenium.Alert alert=getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> list_of_uploaded_files2 = getDriver().findElements(By.xpath("//tr[@id[contains(., 'viewfile_')]]"));
        assertTrue(list_of_uploaded_files2.isEmpty(), "TC is Failed - uploaded files were not deleted from Edisk");

        return new Edisk();
    }

    public Edisk upload_big_amount_of_data()
    {
        for (int i =0; i<1000; i++)
        {
            if (upload_files_big_button.isPresent())
            {
                upload_files_big_button.click();
            }
            else
            {
                upload_files_little_button.click();
            }

            simple_version_of_files_uploading.waitForElementIsPresent();
            simple_version_of_files_uploading.click();

            select_files_button.waitForElementIsPresent();
            select_files_button.click();

            try {
                Runtime.getRuntime().exec("D:\\Projects\\Upload_Files_For_ukr_net.exe");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            close_upload_files_pop_up.waitForElementIsPresent();
            close_upload_files_pop_up.click();
        }
        return new Edisk();
    }
}
