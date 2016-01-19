package Pages;

import Elements.Button;
import Elements.TextField;
import Enums.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;

import static MainSettings.Settings.getDriver;
import static org.testng.Assert.assertTrue;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */

public class StartPage
{
    private TextField login = new TextField(By.xpath(Variables.LOGIN.toString()));
    private TextField password = new TextField (By.xpath(Variables.PASSWORD.toString()));
    private Button login_button = new Button (By.xpath(Variables.LOGIN_BUTTON.toString()));
    private List<WebElement> selected_right_column = getDriver().findElements(By.xpath(Variables.SELECTED_RIGHT_COLUMN.toString()));
    private Button edisk_link = new Button (By.xpath(Variables.EDISK_LINK.toString()));
    private Button upload_files_button = new Button (By.xpath(Variables.UPLOAD_FILES_BUTTON.toString()));
    private Button emails_page = new Button (By.xpath(Variables.EMAILS_LINK.toString()));

    public StartPage login(String logins, String passwords)
    {
        login.waitForElementIsPresent();
        login.enterText(logins);
        password.waitForElementIsPresent();
        password.enterText(passwords);
        login_button.waitForElementIsPresent();
        login_button.click();
        WebElement userIsLoggedIn = null;
        try {
            userIsLoggedIn = getDriver().findElement(By.xpath("//div[text()='kay444415@ukr.net']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        assertTrue(userIsLoggedIn != null, "TC is FAILED - User is NOT logged in");
        return new StartPage();
    }

    public void sinoptik_link_is_present()
    {
        WebElement sinoptik_link = null;
        try {
            sinoptik_link = getDriver().findElement(By.xpath(Variables.SINOPTIK_LINK.toString()));
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        assertTrue(sinoptik_link != null, "TC is FAILED - Sinoptic link is ABSENT!!!");
    }

    public void autosale_link_is_present()
    {
        WebElement autosale_link = null;
        try {
            autosale_link = getDriver().findElement(By.xpath(Variables.AUTOSALE_LINK.toString()));
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        assertTrue(autosale_link != null, "TC is FAILED - Autosale link is ABSENT!!!");
    }

    public void job_link_is_present()
    {
        WebElement job_link = null;
        try {
            job_link = getDriver().findElement(By.xpath(Variables.JOB_LINK.toString()));
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        assertTrue(job_link != null, "TC is FAILED - JOB link is ABSENT!!!");
    }

    public void selected_right_column_items_write_into_file() throws IOException
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String items = "";
        for (WebElement ell : selected_right_column)
        {
            int i = selected_right_column.indexOf(ell);
            if(i==0)
            {
                String el = ell.getText();
                items = el;
            }
            else
            {
                String el = ell.getText();
                items = items + " " + el;
            }
            }

        //Create File
        String file_path = "D:\\Programs\\Programming\\Projects\\KAY_TEXTS.txt";
        File FC = new File(file_path); //Created object of java File class.
        FC.createNewFile(); //Create file.

        //Writing In to file.
        //Create Object of java FileWriter and BufferedWriter class.
        FileWriter FW = new FileWriter(file_path);
        BufferedWriter BW = new BufferedWriter(FW);
        BW.write(items); //Writing In To File.
//        BW.newLine();  //To write next string on new line.
        BW.close();

        try {
            Process p = Runtime.getRuntime().exec("notepad" + "D:\\Programs\\Programming\\Projects\\KAY_TEXTS.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checking_that_selected_right_columt_items_are_the_same_after_login() throws IOException
    {
        //Reading from file.
        // Create Object of java FileReader and BufferedReader class.
        String file_path = "D:\\Programs\\Programming\\Projects\\KAY_TEXTS.txt";
        FileReader FR = new FileReader(file_path);
        BufferedReader BR = new BufferedReader(FR);
        String content = "";
        String content2 = "";

        //Loop to read all lines one by one from file and print It.
        while ((content = BR.readLine()) != null)
        {
            content2 = content2 + content;
        }

        String items = "";
        for (WebElement ell : selected_right_column)
        {
            int i = selected_right_column.indexOf(ell);
            if(i==0)
            {
                String el = ell.getText();
                items = el;
            }
            else
            {
                String el = ell.getText();
                items = items + " " + el;
            }
        }
        assertTrue(items.equals(content2), "TC is FAILED - items are differend");
    }

    public StartPage navigate_to_edisk_and_back()
    {
// For switching via Tabs

//        edisk_link.click();
//        String tab_header = getDriver().getTitle();
//        if (tab_header.equals("eDisk"))
//        {
//            return new Edisk();
//        }
//        else
//        {
//            getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.TAB);
//        }
//        String tab_header1 = getDriver().getTitle();
//        assertTrue(tab_header1.equals("eDisk"), "TC is Failed - incorrect Tab is active");
//        return new Edisk();


// For switching via Browser Windows

        // Store the current window handle
        String winHandleBefore = getDriver().getWindowHandle();
        edisk_link.click();

        // Switch to new window opened
        for (String winHandle : getDriver().getWindowHandles())
        {
            getDriver().switchTo().window(winHandle);
        }
        upload_files_button.click();
        assertTrue(upload_files_button.isPresent(), "TC is failed - Incorrect tab/page is active/displayed");

        // Close the new window, if that window no more required
        getDriver().close();

        // Switch back to original browser (first window)
        getDriver().switchTo().window(winHandleBefore);

        return new StartPage();
    }

    public Edisk navigate_to_Edisk()
    {
        edisk_link.waitForElementIsPresent();
        edisk_link.click();
        for (String winHandle : getDriver().getWindowHandles())
        {
            getDriver().switchTo().window(winHandle);
        }
        return new Edisk();
    }

    public Emails navigation_to_emails_page()
    {
        String windowHeader_before_click = getDriver().getTitle();
        emails_page.waitForElementIsPresent();
        emails_page.click();
        for (String windowHandles_after_click : getDriver().getWindowHandles())
        {
            getDriver().switchTo().window(windowHandles_after_click);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String windowHeader_after_click = getDriver().getTitle();
        System.out.println(windowHeader_after_click);
        assertTrue(getDriver().getTitle().contains("kay444415@ukr.net"), "TC is Failed - the header of the window is incorrect");
        return new Emails();
    }
}
