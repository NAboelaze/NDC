package TestPackage.AdminPackage.Branch;

import Pages.Admin.Branch.SearchBranch;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBranchNegativeTC extends TCBase {

    LoginPage loginobj ;
    DashboardPage dashObj;
    SearchBranch searchBranchObj;
    String branchName = "Test";
    String branchCode = "_";
    String wrongBranchCode = "BRN2";


    @BeforeTest
    public void beforeTest() throws InterruptedException{
        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);

    }

    // Search about branch with an invalid branch code
    @Test
    public void searchWithWrongCode() throws InterruptedException {

        dashObj.openSearchBranchPage();
        searchBranchObj = new SearchBranch(driver);
        searchBranchObj.searchAboutSpecificBranchWithInvalidCode(branchCode);
        Assert.assertEquals(driver.element().getText(searchBranchObj.noResultsMsg),"No Results Found.");
        Thread.sleep(2000);

    }

    // Search about branch with code that does not exist in a specific country
    @Test
    public void searchAboutWrongBranchCodeInASpecificCountry() throws InterruptedException {
        dashObj.openSearchBranchPage();
        searchBranchObj = new SearchBranch(driver);
        searchBranchObj.searchAboutSpecificBranchWithInvalidCountry(wrongBranchCode);
        Assert.assertEquals(driver.element().getText(searchBranchObj.noResultsMsg),"No Results Found.");
        Thread.sleep(2000);

    }

    // Search about active status branch in inactive status
    @Test
    public void searchAboutActiveBranchInInactiveStatus() throws InterruptedException {

        dashObj.openSearchBranchPage();
        searchBranchObj = new SearchBranch(driver);
        searchBranchObj.searchAboutActiveStatusBranchInInactiveStatus(wrongBranchCode);
        Assert.assertEquals(driver.element().getText(searchBranchObj.noResultsMsg),"No Results Found.");



    }
}
