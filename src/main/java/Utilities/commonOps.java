package Utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    @Step("Get Data")
    @Description("Step Description: Get data from DataConfig.xml file")
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    @Step("Choose Operating System")
    @Description("Step Description: Choosing the right operating system according to the value in DataConfig.xml file")
    public static void initMobile(String operatingType)
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        if(operatingType.equalsIgnoreCase("android"))
            driver = initAndroidDriver();
        else if(operatingType.equalsIgnoreCase("ios"))
            driver = initIOSDriver();
        else
            throw new RuntimeException("Invalid operatingType");
        wait = new WebDriverWait(driver,5);
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        touchAction = new TouchAction(mobileDriver);
    }

    @Step("Android Driver Setup")
    @Description("Step Description: Setup to Android Driver")
    public static WebDriver initAndroidDriver()
    {
        try
        {
            mobileDriver = new AndroidDriver(new URL(getData("AppiumServer") + "/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can NOT connect to Appium server - androidDriver, See Details: " + e);
        }
        return mobileDriver;
    }

    @Step("IOS Driver Setup")
    @Description("Step Description: Setup to IOS Driver")
    public static WebDriver initIOSDriver()
    {
        try
        {
            mobileDriver = new IOSDriver(new URL(getData("AppiumServer") + "/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can NOT connect to Appium server - IOSDriver, See Details: " + e);
        }
        return mobileDriver;
    }

    @BeforeClass
    @Description("Step Description: Executed once and before all tests in the class")
    public void startSession ()
    {
        if(getData("Platform").equalsIgnoreCase("mobile"))
        {
            initMobile(getData("operating"));
            managePages.initMob();
        }
        else
        {
            throw new RuntimeException("Invalid platform");
        }
    }

    @AfterClass
    @Description("Step Description: Executed once and after all tests in the class")
    public void closeSession()
    {
        driver.quit();
    }
}
