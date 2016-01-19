package TestCases;

import MainSettings.Settings;
import org.testng.annotations.Test;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
public class TestCases_block_1
{
    public class TestCases extends Settings
    {
//        @Test (priority=0)
//        public void login()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988");
//        }
//
//        @Test (priority=0)
//        public void sinoptik_link_is_present1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").sinoptik_link_is_present();
//        }
//
//        @Test (priority=0)
//        public void autosale_link_is_present1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").autosale_link_is_present();
//        }
//
//        @Test (priority=0)
//        public void job_link_is_present1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").job_link_is_present();
//        }
//
//        @Test (priority=0)
//        public void selected_right_column_items_write_into_file1() throws IOException {
//            mainPage.selected_right_column_items_write_into_file();
//        }
//
//        @Test (priority=0)
//        public void checking_that_selected_right_columt_items_are_the_same_after_login1() throws IOException {
//            mainPage.login("kay444415@ukr.net", "06011988").
//                    checking_that_selected_right_columt_items_are_the_same_after_login();
//        }
//
//        @Test (priority=0)
//        public void navigate_to_edisk1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").
//                    navigate_to_edisk_and_back();
//        }
//
//        @Test (priority=0)
//        public void navigate_to_Edisk1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").navigate_to_Edisk();
//        }
//
//        @Test(priority=0)
//        public void upload_file_to_Edisk1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").navigate_to_Edisk().upload_file_to_Edisk();
//        }
//
//        @Test (priority=1)
//        public void delete_uploaded_files1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").
//                    navigate_to_Edisk().
//                    upload_file_to_Edisk().
//                    delete_uploaded_files();
//        }
//
//        @Test (priority=2)
//        public void upload_big_amount_of_data1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").navigate_to_Edisk().upload_big_amount_of_data();
//        }
//
//        @Test
//        public void navigation_to_emails_page1()
//        {
//            mainPage.login("kay444415@ukr.net", "06011988").navigation_to_emails_page();
//        }

        @Test
        public void select_check_boxes_for_some_emails1()
        {
            mainPage.login("kay444415@ukr.net", "06011988").navigation_to_emails_page().select_check_boxes_for_some_emails();
        }
    }
}
