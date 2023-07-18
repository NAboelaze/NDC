package Pages.Login;

import Pages.BasePage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String ValidUser = "E.saady";
    public String ValidPass = "a";


    By usernameele = By.id("userAlias");
    By passwordele = By.id("password_password");
    By loginbttnele = By.id("login_id");


    public void LoginWithValidData(String username, String password) throws InterruptedException {
        driver.element().type(usernameele, ValidUser);
        driver.element().type(passwordele, ValidPass);
        Thread.sleep(2000);
        driver.element().click(loginbttnele);

    }
}
