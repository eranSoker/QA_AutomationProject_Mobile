package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.mobileFlows.*;

@Listeners(Utilities.listeners.class)
public class experiBankMobile extends commonOps
{
    @Test(priority = 0, description = "Login")
    @Description("Test Description: login to my account")
    public void login()
    {
        loginAccount();
        verifications.assertElementIsDisplayed(mainAppPage.btn_MakePayment);
    }

    @Test(priority = 1, description = "Send Payment")
    @Description("Test Description: Send 1$ as payment")
    public void makeOnePayment()
    {
        String initialBalance = mainAppPage.txt_Balance.getText().replace("Your balance is: ","").replace("$","");
        makePayment("052-1234567","Eran","1");
        String finalBalance = mainAppPage.txt_Balance.getText().replace("Your balance is: ","").replace("$","");
        verifications.assertTrueCondition(Double.parseDouble(initialBalance)-1 == Double.parseDouble(finalBalance));
    }

    @Test(priority = 2, description = "Take Mortgage Request")
    @Description("Test Description: Take a mortgage for 10 years to buy a home")
    public void takeMortgage()
    {
        mortgageRequest("Eran", "June", "32", "address1", "address2");
        verifications.assertElementIsDisplayed(mainAppPage.txt_Balance);
    }

    @Test(priority = 3, description = "ERROR")
    @Description("Test Description: ERROR occurred - screenshot is taken automatically")
    public void error()
    {
        verifications.assertTextInElement(mainAppPage.txt_Balance,"100.00$");
    }
}