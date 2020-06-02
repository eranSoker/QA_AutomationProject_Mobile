package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.util.List;


public class mobileActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        elem.click();
    }

    @Step("Send Text to Text-Field")
    public static void updateText(WebElement elem, String value)
    {
        elem.sendKeys(value);
    }

    @Step("Swipe")
    public static void swipe(int startx, int starty, int endx, int endy, int durationMilis)
    {
        mobileDriver.swipe(startx, starty, endx, endy, durationMilis);
    }

    @Step("Scroll To Element by Text")
    public static void scrollToElementByText(List<WebElement> elems)
    {
        while (elems.size() == 0)
        {
            Dimension size = driver.manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;

            mobileDriver.swipe(startx, starty, startx, endy, 2000);
        }
        elems.get(0).click();
    }

    public static List<WebElement> elems;
    @Step("Scroll To Element by Text")
    public static void scrollToElementByText2(WebElement elem)
    {
            elems.add(elem);
            while (elems.size() == 0)
            {
                Dimension size = driver.manage().window().getSize();
                int starty = (int) (size.height * 0.80);
                int endy = (int) (size.height * 0.20);
                int startx = size.width / 2;

                mobileDriver.swipe(startx, starty, startx, endy, 2000);
            }
            elems.get(0).click();
    }

    @Step("Zoom element")
    public static void zoomElement(WebElement elem)
    {
        mobileDriver.zoom(elem);
    }

    @Step("Shrink element")
    public static void pinchElement(WebElement elem)
    {
        mobileDriver.pinch(elem);
    }

    @Step("Rotate screen")
    public static void rotateScreen()
    {
        String orientation = mobileDriver.getOrientation().value();
        if (orientation.equals("Portrait"))
            mobileDriver.rotate(ScreenOrientation.LANDSCAPE);
        else
            mobileDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    @Step("Drag and Drop")
    public static void dragDrop(WebElement elem, WebElement target)
    {
        touchAction.longPress(elem).moveTo(target).release().perform();
    }

    @Step("Tap on element")
    public static void tapElement(WebElement elem, int durationMilis)
    {
        touchAction.tap(elem,1,durationMilis);
    }
}
