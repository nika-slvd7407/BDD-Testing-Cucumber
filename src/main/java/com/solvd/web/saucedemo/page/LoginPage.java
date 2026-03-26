package com.solvd.web.saucedemo.page;

import com.solvd.web.saucedemo.uiobject.LoginForm;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {

    @FindBy(className = "login-box")
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public MainPage login() throws InterruptedException {
        this.getLoginForm().inputUsername(R.TESTDATA.get("saucedemo_username"));
        Thread.sleep(1000);
        this.getLoginForm().inputPassword(R.TESTDATA.get("saucedemo_password"));
        Thread.sleep(1000);
        return this.getLoginForm().pressLogin();
    }

}
