package Pages.RuleEngine.SearchRuleEngine;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchServiceChargePage extends BasePage {

    public SearchServiceChargePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By searchBttn = By.id("searchButton");
    By activeOption = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[6]/div/div/ul/li[2]/label");
    By inactiveOption =By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div[6]/div/div/ul/li[1]/label");
    public By resultTable = By.id("air_tb");
    public void searchAboutActiveServiceCharge() {
        driver.element().click(activeOption);
        driver.element().click(searchBttn);
    }

    public void searchAboutInActiveServiceCharge() {
        driver.element().click(inactiveOption);
        driver.element().click(searchBttn);
    }
}
