package PageObjects.ExperiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class mortgagePage
{
    private static final String countryName = "Thailand";

    @FindBy(id="nameTextField")
    public WebElement txtField_Name;

    @FindBy(id="lastNameTextField")
    public WebElement txtField_LastName;

    @FindBy(id="ageTextField")
    public WebElement txtField_Age;

    @FindBy(id="addressOneTextField")
    public WebElement txtField_AddressOne;

    @FindBy(id="addressTwoTextField")
    public WebElement txtField_AddressTwo;

    @FindBy(id="countryButton")
    public WebElement btn_Select;

    @FindBy(xpath="//*[@text='"+ countryName +"']")
    public List<WebElement> txt_Country;

    @FindBy(id="nextButton")
    public WebElement btn_Next;

    @FindBy(id="cancelButton")
    public WebElement btn_Cancel;

    @FindBy(xpath="//*[@text='Home']")
    public WebElement radioBtn_TypeOfLoan;

    @FindBy(xpath="//*[@text='10']")
    public List<WebElement> radioBtn_NumOfYears;

    @FindBy(xpath="//*[@text='Business']")
    public List<WebElement> radioBtn_TypeOfJob;

    @FindBy(xpath="//*[@text='25,00,000']")
    public List<WebElement> radioBtn_YearlyIncome;

    @FindBy(id="saveButton")
    public List<WebElement> btn_Save;
}
