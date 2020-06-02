package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Condition is True")
    public static void assertTrueCondition (boolean bol)
    {
        assertTrue(bol);
    }

    @Step("Verify Element is Displayed")
    public static void assertElementIsDisplayed (WebElement elem)
    {
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify Partial Text in Element")
    public static void assertPartialTextInElement (WebElement elem, String expectedPartialText)
    {
        assertTrue(elem.getText().contains(expectedPartialText));
    }

    @Step("Verify Text in Element")
    public static void assertTextInElement (WebElement elem, String expectedValue)
    {
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify Text Equal between two Elements")
    public static void assertTextEqualElements (WebElement elem, WebElement elem2)
    {
        assertEquals(elem.getText(), elem2.getText());
    }

    @Step("Verify the number of Elements Equals to Value")
    public static void assertNumberOfElements (List<WebElement> elems, int expectedValue)
    {
        assertEquals(elems.size(), expectedValue);
    }

    @Step("Verify Text to Text")
    public static void assertTextToText (String actualText, String expectedText)
    {
        assertEquals(actualText, expectedText);
    }


    //softAssertion

    @Step("Verify Condition is True")
    public static void softAssertTrueCondition (boolean bol)
    {
        softAssertion.assertTrue(bol);
    }

    @Step("Verify Element is Displayed")
    public static void softAssertElementIsDisplayed (WebElement elem)
    {
        softAssertion.assertTrue(elem.isDisplayed());
    }

    @Step("Verify Partial Text in Element")
    public static void softAssertPartialTextInElement (WebElement elem, String expectedPartialText)
    {
        softAssertion.assertTrue(elem.getText().contains(expectedPartialText));
    }

    @Step("Verify Text in Element")
    public static void softAssertTextInElement (WebElement elem, String expectedValue)
    {
        softAssertion.assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify Text Equal between two Elements")
    public static void softAssertTextEqualElements (WebElement elem, WebElement elem2)
    {
        softAssertion.assertEquals(elem.getText(), elem2.getText());
    }

    @Step("Verify the number of Elements Equals to Value")
    public static void softAssertNumberOfElements (List<WebElement> elems, int expectedValue)
    {
        softAssertion.assertEquals(elems.size(), expectedValue);
    }
}
