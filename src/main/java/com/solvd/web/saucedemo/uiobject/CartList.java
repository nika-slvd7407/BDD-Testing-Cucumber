package com.solvd.web.saucedemo.uiobject;

import com.solvd.web.saucedemo.page.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartList extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'cart_item')]")
    private List<ExtendedWebElement> cartItems;

    @FindBy(xpath = ".//*[contains(@data-test, 'checkout']")
    private ExtendedWebElement checkoutButton;

    public CartList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private ExtendedWebElement getItem(int index) {
        return cartItems.get(index);
    }

    public String getItemName(int index) {
        return getItem(index).findElement(By.xpath(".//*[contains(@class, 'inventory_item_name')]")).getText().toLowerCase();
    }

    public Double getItemCost(int index) {
        return Double.valueOf(
                getItem(index).findElement(By.xpath(".//*[contains(@class, 'inventory_item_price')]")).getText().substring(1)
        );
    }

    public CheckoutPage pressCheckout() {
        checkoutButton.click();
        return new CheckoutPage(getDriver());
    }
}
