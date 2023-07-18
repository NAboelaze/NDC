package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MultiCityBooking extends BasePage {
    public MultiCityBooking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By Type4TripMulti = By.xpath("//*[@id=\"flight-landing-wrap\"]/div/div/div/div[2]/div/div[1]/ul/li[3]");

    By Branch = By.id("branchListId");

    By Agency = By.id("agencyListId");

    By AgencyStaff = By.id("selectagenId");
    By StartingFrom1 = By.id("startingFrom_4");
    By StartingFrom2 = By.id("startingFrom_5");


    By Destenation1 = By.id("goingTo_4");
    By Destenation2 = By.id("goingTo_5");


    By DateOfJourneyS1 = By.id("dateOfJourney_3");
    By SelectedMonthS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By SelectedDayS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a");


    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormMultiCity\"]/div[11]/input");
    By TicketCheckBox = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");

    public void searchMultiCityWayFlight(String from, String Des_to1, String Des_to2, String month) throws InterruptedException {
        driver.element()
                .click(Branch)
                .select(Branch, "Test")
                .click(Agency);
        Thread.sleep(800);
        driver.element().select(Agency, "Test Egypt")
                .click(AgencyStaff);
        Thread.sleep(800);
        driver.element().select(AgencyStaff, "Nagy abdelhamid");
        Thread.sleep(1000);
        driver.element().click(Type4TripMulti)
                .type(StartingFrom1, from)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER)
                .type(Destenation1, Des_to1)
                .keyPress(Destenation1, Keys.ARROW_DOWN)
                .keyPress(Destenation1, Keys.ENTER)
                .click(DateOfJourneyS1)
                .select(SelectedMonthS1, month)
                .click(SelectedDayS1)
                .type(Destenation2, Des_to2)
                .keyPress(Destenation2, Keys.ARROW_DOWN)
                .keyPress(Destenation2, Keys.ENTER)
                .click(SearchBttn)
                .click(TicketCheckBox);


    }

}
