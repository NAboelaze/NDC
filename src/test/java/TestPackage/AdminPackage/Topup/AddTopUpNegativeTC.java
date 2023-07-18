package TestPackage.AdminPackage.Topup;

import Pages.Admin.Topup.AddTopUpPage;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddTopUpNegativeTC extends TCBase {

    String branchName="Test";
    String topUpLimit= "1000";
    String receiptNo= "_";

    LoginPage loginobj;
    DashboardPage dashObj;
    AddTopUpPage addTopUpObj;

    @BeforeTest
    public void login()throws InterruptedException{
        loginobj =new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
    }

    @Test
    public void addingTopUpAmountToBranchWithInvalidData() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithInValidData(branchName,topUpLimit,receiptNo);
        Assert.assertEquals(driver.element().getText(addTopUpObj.errorMsg),"Invalid Receipt Number, alphanumeric are allowed");
    }

    @Test
    public void addingTopUpAmountToBranchWithEmptydData() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithEmptyData();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Admin/addTopUpForm");
    }

    @Test
    public void addingTopUpAmountToBranchWithEmptyBranch() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithEmptyreceiptno(branchName,topUpLimit);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Admin/addTopUpForm");

    }
    @Test
    public void addingTopUpAmountToBranchWithEmptyReceiptNo() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithEmptyBranch(topUpLimit,receiptNo);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Admin/addTopUpForm");
    }
    @Test
    public void addingTopUpAmountToBranchWithEmptytopuplimit() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithEmptytopuplimit(branchName,receiptNo);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Admin/addTopUpForm");

    }
    @Test
    public void addingTopUpAmountToBranchWithEmptyFile() throws InterruptedException {

        dashObj.openAddTopUpPage();
        addTopUpObj = new AddTopUpPage(driver);
        addTopUpObj.addTopUpTOBranchWithEmptyFile(branchName,topUpLimit,receiptNo);
        Assert.assertEquals(driver.getDriver().getCurrentUrl(),"http://192.168.1.50:8080/odeysysadmin/Admin/addTopUpForm");

    }
}
