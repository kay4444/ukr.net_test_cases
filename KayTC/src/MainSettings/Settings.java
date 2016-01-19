package MainSettings;

import Pages.StartPage;
import TrackReporting.CaptureScreenShotOnFailureListener;
import TrackReporting.LoggingEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

/**
 * Created by serhii.kaihorodov on 1/4/2016.
 */
@Listeners(CaptureScreenShotOnFailureListener.class)
public class Settings {
    protected static WebDriver driver;
    protected String baseURL = "https://www.ukr.net";
    private static final WebDriverEventListener eventListener = new LoggingEventListener();
    protected StartPage mainPage;

    @BeforeMethod
    public void setUp()
    {
        driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener);
        getDriver().get(baseURL);
        mainPage = new StartPage();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void waitInSeconds (int seconds)
    {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
