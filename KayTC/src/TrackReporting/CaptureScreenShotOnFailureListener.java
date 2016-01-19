package TrackReporting;

/**
 * Created by serhii.kaihorodov on 12/9/2015.
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static MainSettings.Settings.getDriver;

public class CaptureScreenShotOnFailureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        File file = new File("D:\\Programs\\Programming\\Projects\\Reports\\MyAutoTest_4");
        Calendar calendar = GregorianCalendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS", Locale.ENGLISH);
        Reporter.setCurrentTestResult(result);
        String path = file.getAbsolutePath();
        String reportsFolder = path + "\\target\\surefire-reports\\html\\";
        String screenShotsFolder = "failure-screenshots\\";
        String screenShotName = result.getMethod().getMethodName() + "(" + result.getTestClass().getName() + ")" + "-"
                + formatter.format(calendar.getTime()) + ".png";
        // Create the filename for the screen shots
        String fileName = reportsFolder
                + screenShotsFolder
                + screenShotName;
        //Put the path, written with red font and link to the screen shot into ReportNG output.
        Logger.log("<font color='red'>Fail! Screenshot with test failure saved at " + fileName + "</font>");
        Logger.log("<a href='" + screenShotsFolder + screenShotName + "'>" + screenShotName + "</a>");
        try {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                org.apache.commons.io.FileUtils.copyFile(scrFile, new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnreachableBrowserException e) {
            Logger.log("Cannot capture the screenshot. Error communicating with the remote browser. It may have died.");
        }
        Reporter.setCurrentTestResult(null);
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        // will be called after test will be skipped
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // will be called after test will pass
    }

}
