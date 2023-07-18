package Pages.BookingMidOffice.Booking;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RoundTripBooking extends BasePage {
    public RoundTripBooking(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }
    By Type4TripRound = By.xpath("//*[@id=\"flight-landing-wrap\"]/div/div/div/div[2]/div/div[1]/ul/li[2]");

    By Branch = By.id("branchListId");

    By Agency = By.id("agencyListId");

    By AgencyStaff = By.id("selectagenId");

    By StartingFrom1 = By.id("startingFrom_2");
    By StartingFrom2 = By.id("startingFrom_3");

    By Destenation1 = By.id("goingTo_2");
    By Destenation2 = By.id("goingTo_3");


    By DateOfJourneyS1 = By.id("dateofjourney_1");
    By SelectedMonthS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
    By SelectedDayS1 = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a");



    By SearchBttn = By.xpath("//*[@id=\"flightWidgetFormRoundTrip\"]/div[14]/input");
    By TicketCheckBox = By.xpath("//*[@id=\"round-trip\"]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/input");
    public void searchRoundWayFlight(String from,String to,String month) throws InterruptedException {
        driver.element()
                .click(Branch)
                .select(Branch,"Test")
                .click(Agency);
        Thread.sleep(800);
        driver.element().select(Agency,"Test Egypt")
                .click(AgencyStaff);
        Thread.sleep(800);
        driver.element().select(AgencyStaff,"Nagy abdelhamid");
        Thread.sleep(1000);
        driver.element().click(Type4TripRound)
                .type(StartingFrom1,from)
                .keyPress(StartingFrom1, Keys.ARROW_DOWN)
                .keyPress(StartingFrom1, Keys.ENTER)
                .type(Destenation1,to)
                .keyPress(Destenation1, Keys.ARROW_DOWN)
                .keyPress(Destenation1, Keys.ENTER)
                .click(DateOfJourneyS1)
                .select(SelectedMonthS1, month)
                .click(SelectedDayS1)
                .click(SearchBttn)
                .click(TicketCheckBox);


    }

}
