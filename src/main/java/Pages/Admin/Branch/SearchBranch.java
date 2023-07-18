package Pages.Admin.Branch;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchBranch extends BasePage {
    public SearchBranch(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By branchCodeTxt = By.id("branchCode");
    By branchNameTxt = By.id("groupName");
    By searchBttn = By.id("searchButton");
    By InactiveStatus = By.xpath("/html/body/div/section/div/div[2]/div/div/div[4]/form/div/div[3]/div[2]/div/ul/li[1]/label/label");
    By bothStatus = By.xpath("//*[@id=\"formId\"]/div/div[3]/div[2]/div/ul/li[3]/label/label"); // both status icon
    By approveIcon = By.xpath("/html/body/div/section/div/div[2]/div/div/div[4]/form/div/div[5]/div/table/tbody/tr[1]/td[7]/a[2]");
    By confirmPopUpMsg = By.id("modal-content");
    By remarksTxt = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div/div[5]/div/table/tbody/tr[1]/td[7]/div/div/div/div[2]/textarea");
    By approveBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div[4]/form/div/div[5]/div/table/tbody/tr[1]/td[7]/div/div/div/div[3]/button[1]");
    public By branchTable = By.id("air_tb");
    public By errorMssg = By.xpath("//*[@id=\"msg\"]/span"); // no data found after search
    public By noResultsMsg = By.xpath("//div[@id = \"msg\"]//span");
    By editIcon =By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[7]/a[1]/img");// icon press on it
    By countryInput = By.xpath("//input[@id = 'country-dropdown']");
    By country = By.xpath("//li[@id='c212']");
    By status = By.xpath("//*[@id=\"formId\"]/div/div[3]/div[2]/div/ul/li[1]/label/label");
    public void searchAboutAnyBranchWithActiveStatus() {
        driver.element().click(searchBttn);

    }

    public void searchAboutAnyBranchWithInActiveStatus() {
        driver.element().click(InactiveStatus);
        driver.element().click(searchBttn);

    }

    public void searchAboutSpecificBranchWithValidData(String branchCode, String branchName) {
        driver.element().type(branchCodeTxt, branchCode);
        driver.element().type(branchNameTxt, branchName);
        driver.element().click(searchBttn);

    }

    public void approveNewBranchRequest() {
        driver.element().click(approveIcon);
        driver.assertThat().element(confirmPopUpMsg).isVisible();
        driver.element().type(remarksTxt, "done");
        driver.element().click(approveBttn);

    }

    public void searchAboutSpecificBranchUsingBranchName(String branchName) {
        driver.element().type(branchNameTxt, branchName);
        driver.element().click(bothStatus);
        driver.element().click(searchBttn);

    }

    public void searchAboutSpecificBranchUsingBranchNameAndApproveIt(String branchName) throws InterruptedException {
        driver.element().type(branchNameTxt, branchName)
                .click(bothStatus)
                .click(searchBttn);
        if (isElementPresent(errorMssg)) {
            driver.quit();
        }
                driver.element().click(approveIcon);
        Thread.sleep(1000);
        driver.element().click(approveBttn);


    }
    public void searchAboutSpecificBranchWithInvalidCode(String branchCode) {
        driver.element().type(branchCodeTxt, branchCode).click(searchBttn);

    }
    public void searchAboutSpecificBranchWithInvalidCountry(String branchCode) {
        driver.element().type(branchCodeTxt, branchCode);
        driver.element().type(countryInput,"el");
        driver.element().click(country);

        driver.element().click(searchBttn);

    }

    public void searchAboutActiveStatusBranchInInactiveStatus(String branchCode) {
        driver.element().type(branchCodeTxt, branchCode).click(status);
        driver.element().click(searchBttn);

    }
}

