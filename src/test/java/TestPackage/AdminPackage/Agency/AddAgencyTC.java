package TestPackage.AdminPackage.Agency;

import Pages.Admin.Agency.AddAgency;
import TestPackage.Login.LoginPageTC;
import TestPackage.BasePage.TCBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddAgencyTC extends TCBase {

    AddAgency addagencyobject;
    LoginPageTC loginObj3;


    @Test
    public void AddWithValidData() throws InterruptedException {
        loginObj3 = new LoginPageTC();
        loginObj3.loginWithValidCredentials();
        addagencyobject = new AddAgency(driver);
        addagencyobject.addAgencyWithValidData();
        driver.assertThat().element(By.xpath("//*[@id=\"statusMsg\"]/font/font")).isVisible();


    }

}

