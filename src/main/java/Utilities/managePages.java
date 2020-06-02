package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void initMob()
    {
        loginApp = PageFactory.initElements(driver, PageObjects.ExperiBank.loginPage.class);
        mainAppPage = PageFactory.initElements(driver, PageObjects.ExperiBank.mainPage.class);
        makePaymentApp = PageFactory.initElements(driver, PageObjects.ExperiBank.makePaymentPage.class);
        mortgageRequestApp = PageFactory.initElements(driver, PageObjects.ExperiBank.mortgagePage.class);
    }
}
