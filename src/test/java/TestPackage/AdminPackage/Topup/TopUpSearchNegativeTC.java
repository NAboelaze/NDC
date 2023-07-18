package TestPackage.AdminPackage.Topup;

import Pages.Admin.Topup.TopUpSearchPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopUpSearchNegativeTC extends TCBase {
    DashboardPage dashObj;
    LoginPage loginObj;
    TopUpSearchPage topUpObj;
    @Test
    public void searchAboutInValidTopUp() throws InterruptedException {
        loginObj = new LoginPage(driver);
        loginObj.LoginWithValidData(loginObj.ValidUser, loginObj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openTopUpPage();
        topUpObj = new TopUpSearchPage(driver);
        topUpObj.searchAboutInValidTopUp();
        Assert.assertEquals(driver.element().getText(topUpObj.noResultsMsg),"No Results Found.");

    }

}
