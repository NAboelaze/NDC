package TestPackage.BookinMidOffice.Booking;

import Pages.BookingMidOffice.Booking.MultiCityBooking;
import Pages.DashboardPage;
import Pages.Login.LoginPage;
import TestPackage.BasePage.TCBase;
import org.testng.annotations.Test;

public class MultiCityBookingTC extends TCBase {
    DashboardPage dashObj;
    LoginPage loginobj;
    MultiCityBooking adminMultiCityWayObj;


    @Test
    public void searchingWithMultiCityFlights() throws InterruptedException{

        loginobj = new LoginPage(driver);
        loginobj.LoginWithValidData(loginobj.ValidUser, loginobj.ValidPass);
        dashObj = new DashboardPage(driver);
        dashObj.openBookingPage();
        adminMultiCityWayObj = new MultiCityBooking(driver);
        adminMultiCityWayObj.searchMultiCityWayFlight("CAI","DXB","JED","Dec");


    }

}
