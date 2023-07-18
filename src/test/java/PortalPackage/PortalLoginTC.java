package PortalPackage;

import Portal.PortalLogin;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class PortalLoginTC {
    public String PortalURL = "https://ndc-eg.com/odeysysportal/login/loginForm";
    public static SHAFT.GUI.WebDriver   driver;


    @BeforeSuite
    public void OpenBrowse() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(PortalURL);
        driver.browser().maximizeWindow();

    }


    @AfterSuite

    public void CloseBrowser() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().closeCurrentWindow();
        driver.quit();
    }

    PortalLogin portalloginobject;

    @Test
    public void PortalLoginWithValidCredentials() {
        portalloginobject = new PortalLogin(driver);
        portalloginobject.PortalLoginWithValidData();
    }


}
