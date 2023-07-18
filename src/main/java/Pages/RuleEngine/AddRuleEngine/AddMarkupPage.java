package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.util.Calendar;

public class AddMarkupPage extends BasePage {
    public AddMarkupPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By productList = By.id("ruleGroupId");
    By markupName = By.id("markupName");
    By markupDescription = By.id("markupDesc");
    By markupFromPeriod = By.id("validFrom");
    By markupToPeriod = By.id("validTo");
    By countryDropDown = By.id("country-dropdown");  //text send to it country name
    By countryResultList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[1]/div[1]/div[2]/div[2]"); // list choose from it country
    By imageBranch = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[1]/img"); // image click on it to select all branches
    By optionAllBranches = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[2]/div[2]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL
    By imageAgency = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[1]/img"); // image click on it to select all agencies
    By optionAllAgencies = By.xpath("/html/body/div/section/div/div[2]/div/div/form/div[2]/div[6]/div[3]/div[1]/div[1]/div[2]/div[2]/div/input"); // OPTION ALL agencies
    By ruleCriteria = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[6]/div[4]/div[1]/ul"); //list specify criteria from it
    By selectCriteriaList = ruleCriteria.id("entity_0"); // select list (supplier choice )
    By searchIcon = ruleCriteria.id("ssearch_0");
    By supplierList = By.id("add_entity"); // list of suppliers
    By allSupplierOptions = supplierList.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[9]/div/div/div[2]/div[3]/div[1]/div[2]/label[1]/input"); //click on it
    By addBttn = By.id("add_restricted_airline"); // add button click on it
    By saveBttn = By.id("save_airline"); // save button
    By fareList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[1]/select"); // fare list
    By amountOrPercentageList = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[2]/select"); // percentage or amount list
    By MarkupAmount = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div/div[2]/div[3]/input");
    public By statusMssg = By.id("statusMsg");
    By sendForApprovalBttn = By.id("sendApprovel"); // send for approval button
    Calendar calendar = Calendar.getInstance();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void addMarkupWithValidCriteria(String productType, String markupname, String markupdescription, String country,
                                           String supplierChoice, String fareType, String amount, int value) {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productList, productType)
                .type(markupName, markupname)
                .type(markupDescription, markupdescription)
                .type(markupFromPeriod, today.format(myFormatObj))
                .type(markupToPeriod, tomorrow.format(myFormatObj))
                .type(countryDropDown, country)
                .click(countryResultList)
                .click(imageBranch)
                .click(optionAllBranches)
                .click(imageAgency)
                .click(optionAllAgencies)
                .select(selectCriteriaList, supplierChoice)
                .click(searchIcon)
                .click(allSupplierOptions)
                .click(addBttn)
                .click(saveBttn)
                .select(fareList, fareType)
                .select(amountOrPercentageList, amount)
                .type(MarkupAmount, String.valueOf(value))
                .click(sendForApprovalBttn);


    }


}
