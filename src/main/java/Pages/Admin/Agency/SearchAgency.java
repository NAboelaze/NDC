package Pages.Admin.Agency;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

    public class SearchAgency extends BasePage {

        public SearchAgency(SHAFT.GUI.WebDriver driver) {
            super(driver);
        }

        By Admin = By.xpath("//*[@id=\"Admin\"]/a");
        By LeftCorner = By.id("accordion");
        By Agency = By.xpath("//*[@id=\"Agency\"]");
        By Agency2 = By.xpath("//*[@id=\"searchAgency\"]");
        By Status = By.xpath("//*[@id=\"formId\"]/div/div/div[6]/div[2]/label");
        By searchBttn = By.id("searchButton");
        public By ResultsTable = By.id("air_tb");


        public void searchForAgencyWithValidData() {
            driver.element().click(Admin);
            driver.element().click(Agency);
            driver.element().click(Agency2);
            driver.element().click(searchBttn);
        }


    }

