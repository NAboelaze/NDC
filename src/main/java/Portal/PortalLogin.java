package Portal;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class PortalLogin {
    protected SHAFT.GUI.WebDriver driver;

    public PortalLogin(SHAFT.GUI.WebDriver driver) {
        super();
        this.driver = driver;
    }

    public String PortalURL = "https://ndc-eg.com/odeysysportal/login/loginForm";

    public void navigateToPage(String PortalURL) {
        driver.browser().navigateToURL(PortalURL);
    }



    By AgencyCode = By.id("agencyCodeMain");
    By Email = By.id("userAlias");
    By Password = By.id("password_password");
    By LoginBttn = By.xpath("//*[@id=\"loginPage\"]/div/div[2]/div/div[1]/div[5]/input");


    public void PortalLoginWithValidData() {

        driver.element().type(AgencyCode, "AGN2")
                .type(Email, "E.saady@ndceg.com")
                .type(Password, "a")
                .click(LoginBttn);

        //public void PortalLoginWithValidData(String code, String emailforagency, String pass) {
        // driver.element().type(AgencyCode, ValidAgencyCode);
        //  driver.element().type(Email, ValidEmail);
        //driver.element().type(Password,ValidPassword);
        // driver.element().Click(LoginBttn);


        //}
    }


}