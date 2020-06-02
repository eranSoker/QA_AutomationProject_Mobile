package WorkFlows;

import Extensions.mobileActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlows extends commonOps
{
    @Step("Login to your account")
    public static void loginAccount ()
    {
        mobileActions.updateText(loginApp.txtField_UserName, getData("UserName"));
        mobileActions.updateText(loginApp.txtField_Password, getData("Password"));
        mobileActions.click(loginApp.btn_Login);
    }

    @Step("Make Payment")
    public static void makePayment (String phone, String name, String amount)
    {
        mobileActions.click(mainAppPage.btn_MakePayment);
        mobileActions.updateText(makePaymentApp.txtField_Phone,phone);
        mobileActions.updateText(makePaymentApp.txtField_Name,name);
        mobileActions.updateText(makePaymentApp.txtField_Amount,amount);
        mobileActions.click(makePaymentApp.btn_Select);
        mobileActions.scrollToElementByText(makePaymentApp.txt_Country);
        mobileActions.click(makePaymentApp.btn_SendPayment);
        mobileActions.click(makePaymentApp.btn_YesToSend);
    }

    @Step("Take a Mortgage")
    public static void
    mortgageRequest (String name, String lastName, String age, String address1, String address2)
    {
        mobileActions.click(mainAppPage.btn_MortgageRequest);
        mobileActions.updateText(mortgageRequestApp.txtField_Name,name);
        mobileActions.updateText(mortgageRequestApp.txtField_LastName,lastName);
        mobileActions.updateText(mortgageRequestApp.txtField_Age,age);
        mobileActions.updateText(mortgageRequestApp.txtField_AddressOne,address1);
        mobileActions.updateText(mortgageRequestApp.txtField_AddressTwo,address2);
        mobileActions.click(mortgageRequestApp.btn_Select);
        mobileActions.scrollToElementByText(mortgageRequestApp.txt_Country);
        mobileActions.click(mortgageRequestApp.btn_Next);
        mobileActions.click(mortgageRequestApp.radioBtn_TypeOfLoan);
        mobileActions.scrollToElementByText(mortgageRequestApp.radioBtn_NumOfYears);
        mobileActions.scrollToElementByText(mortgageRequestApp.radioBtn_TypeOfJob);
        mobileActions.scrollToElementByText(mortgageRequestApp.radioBtn_YearlyIncome);
        mobileActions.scrollToElementByText(mortgageRequestApp.btn_Save);
    }
}
