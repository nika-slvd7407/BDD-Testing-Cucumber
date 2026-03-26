package com.solvd.web.saucedemo.uiobject;

import com.solvd.web.saucedemo.page.MainPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(id = "user-name")
    private ExtendedWebElement username;

    @FindBy(id = "password")
    private ExtendedWebElement password;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void inputUsername(String userName) {
        username.type(userName);
    }

    public void inputPassword(String passwordInput) {
        password.type(passwordInput);
    }

    public MainPage pressLogin() {
        loginButton.click();
        return new MainPage(driver);
    }

}
