package Pages.RuleEngine.AddRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddCancellationChargePage extends BasePage {
    public AddCancellationChargePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By productType = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[4]/div/select");
    By cancellationChargeName = By.id("cancellationChargeName");
    By cancellationChargeDescription = By.id("cancellationChargeDesc");
    By cancellationFromPeriod = By.id("validFrom");
    By cancellationToPeriod = By.id("validTo");
    By countryPos = By.id("country-dropdown"); // text on it egy
    By countryCheckBox = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[7]/div/div[1]/div[2]/div[2]/ul/li/input"); //click on it
    By fareType = By.id("fareType"); //select "Total Fare" from list
    By amountType = By.id("cancellationChargeType"); // select amount from it
    By leivedBy = By.id("leivedBy"); //select Per Person from list
    By adultAmount = By.id("cancellationChargeValAdult"); // type amount in it
    By childAmount = By.id("cancellationChargeValChild");// type amount in it
    By infantAmount = By.id("cancellationChargeValInfant"); // type amount in it
    By sendForApprovalBttn = By.xpath("/html/body/div[1]/section/div/div[2]/div/div/form/div[2]/div[9]/input[1]");
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public By statusMssg = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/span/font");

    public void addCancellationChargeWithValidData(String producttype, String cancellationname, String cancellationdescription, String country,
                                                   String faretype, String amount, String leivedoption, int adultamount, int childamount, int infantamount){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        driver.element().select(productType, producttype)
                .type(cancellationChargeName, cancellationname)
                .type(cancellationChargeDescription, cancellationdescription)
                .type(cancellationFromPeriod, today.format(myFormatObj))
                .type(cancellationToPeriod, tomorrow.format(myFormatObj))
                .type(countryPos, country)
                .click(countryCheckBox)
                .select(fareType, faretype)
                .select(amountType, amount)
                .select(leivedBy, leivedoption)
                .type(adultAmount, String.valueOf(adultamount))
                .type(childAmount, String.valueOf(childamount))
                .type(infantAmount, String.valueOf(infantamount))
                .click(sendForApprovalBttn);

    }


}
