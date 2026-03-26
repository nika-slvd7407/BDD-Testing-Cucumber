package com.solvd.web.saucedemo.page;

import com.solvd.web.saucedemo.uiobject.CartList;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[contains (@class, 'cart_list')]")
    private CartList cartList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartList getCartList() {
        return cartList;
    }
}
