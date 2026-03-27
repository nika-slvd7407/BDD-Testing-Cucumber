package com.solvd.web.saucedemo.uiobject;

import com.solvd.web.saucedemo.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryList extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'inventory_item')]")
    private List<ExtendedWebElement> items;

    @FindBy(xpath = "//*[contains(@class,'shopping_cart_link')]")
    private ExtendedWebElement cartButton;

    public InventoryList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private ExtendedWebElement getItem(int index) {
        return items.get(index);
    }

    public String getItemName(int index) {
        return getItem(index)
                .findElement(By.xpath(".//*[contains(@data-test,'inventory-item-name')]"))
                .getText()
                .toLowerCase();
    }

    public Double getItemPrice(int index) {
        return Double.valueOf(
                getItem(index)
                        .findElement(By.xpath(".//*[contains(@data-test,'inventory-item-price')]"))
                        .getText()
                        .substring(1)
        );
    }

    public void addItem(int index) {
        getItem(index)
                .findElement(By.xpath(".//*[contains(@name,'add-to-cart')]"))
                .click();
    }

    public CartPage openCart() {
        cartButton.click();
        return new CartPage(driver);
    }
}