package PageObjects.ExperiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class makePaymentPage
{
    private static final String countryName = "Brazil";

    @FindBy(id="phoneTextField")
    public WebElement txtField_Phone;

    @FindBy(id="nameTextField")
    public WebElement txtField_Name;

    @FindBy(id="amountTextField")
    public WebElement txtField_Amount;

    @FindBy(id="countryButton")
    public WebElement btn_Select;

    @FindBy(xpath="//*[@text='"+ countryName +"']")
    public List<WebElement> txt_Country;

    @FindBy(id="sendPaymentButton")
    public WebElement btn_SendPayment;

    @FindBy(id="cancelButton")
    public WebElement btn_Cancel;

    @FindBy(id="button1")
    public WebElement btn_YesToSend;
}
