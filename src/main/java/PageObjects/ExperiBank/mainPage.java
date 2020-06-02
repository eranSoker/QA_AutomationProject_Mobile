package PageObjects.ExperiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage
{
    @FindBy(xpath="//*[contains(text(), 'Your balance is:')]")
    public WebElement txt_Balance;

    @FindBy(id="makePaymentButton")
    public WebElement btn_MakePayment;

    @FindBy(id="mortageRequestButton")
    public WebElement btn_MortgageRequest;

    @FindBy(id="expenseReportButton")
    public WebElement btn_ExpenseReport;

    @FindBy(id="logoutButton")
    public WebElement btn_Logout;
}
