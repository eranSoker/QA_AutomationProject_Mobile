package Utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static SoftAssert softAssertion = new SoftAssert();

    public static MobileDriver mobileDriver;
    public static AndroidDriver androidDriver;
    public static IOSDriver iosDriver;
    public static TouchAction touchAction;

    public static PageObjects.ExperiBank.loginPage loginApp;
    public static PageObjects.ExperiBank.mainPage mainAppPage;
    public static PageObjects.ExperiBank.makePaymentPage makePaymentApp;
    public static PageObjects.ExperiBank.mortgagePage mortgageRequestApp;
}
