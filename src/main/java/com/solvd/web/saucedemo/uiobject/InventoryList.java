package com.solvd.web.saucedemo.uiobject;

import com.solvd.web.saucedemo.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryList extends AbstractUIObject {

    @FindBy(xpath = "(.//*[contains (@class, 'inventory_item_description')])[1]")
    private ExtendedWebElement item1;

    @FindBy(xpath = "(.//*[contains (@class, 'inventory_item_description')])[2]")
    private ExtendedWebElement item2;

    @FindBy(xpath = "//*[contains (@class, 'shopping_cart_link')]")
    private ExtendedWebElement checkoutButton;

    public InventoryList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItem1Name() {
        return getItem1().findElement(By.xpath(".//*[contains (@data-test, 'inventory-item-name')]")).getText().toLowerCase();
    }

    public String getItem2Name() {
        return getItem2().findElement(By.xpath(".//*[contains (@data-test, 'inventory-item-name')]")).getText().toLowerCase();
    }

    public Double getItem1Cost() {
        return Double.valueOf(getItem1().findElement(By.xpath(".//*[contains (@data-test, 'inventory-item-price')]")).getText().substring(1));
    }

    public Double getItem2Cost() {
        return Double.valueOf(getItem2().findElement(By.xpath(".//*[contains (@data-test, 'inventory-item-price')]")).getText().substring(1));
    }

    public void addItem1() {
        item1.findElement(By.xpath(".//*[contains (@name, 'add-to-cart')]")).click();
    }

    public void addItem2() {
        item2.hover();
        item2.findElement(By.xpath(".//*[contains (@name, 'add-to-cart')]")).click();
    }

    public ExtendedWebElement getItem1() {
        return item1;
    }

    public ExtendedWebElement getItem2() {
        return item2;
    }

    public CartPage pressCart() {
        getCheckoutButton().hover();
        getCheckoutButton().click();
        return new CartPage(driver);
    }

    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }
}
