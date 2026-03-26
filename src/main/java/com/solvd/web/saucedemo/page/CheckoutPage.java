package com.solvd.web.saucedemo.page;

import com.solvd.web.saucedemo.uiobject.CheckoutForm;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(className = "checkout_info_wrapper")
    public CheckoutForm checkoutForm;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}
