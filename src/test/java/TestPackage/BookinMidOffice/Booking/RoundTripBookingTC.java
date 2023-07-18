package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.RoundTripBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class RoundTripBookingTC extends TCBase{
    DashboardPage dashObj;
    LoginPage loginobj;
    RoundTripBooking adminRoundWayObj;



    @Test
    public void searchingWithRoundWayFlights() throws InterruptedException{

        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminRoundWayObj = new RoundTripBooking(driver);
        adminRoundWayObj.searchRoundWayFlight("CAI","SSH","Dec");

    }


}
