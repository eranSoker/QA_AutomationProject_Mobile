package PageObjects.ExperiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage
{
    @FindBy(id="usernameTextField")
    public WebElement txtField_UserName;

    @FindBy(id="passwordTextField")
    public WebElement txtField_Password;

    @FindBy(id="loginButton")
    public WebElement btn_Login;
}
