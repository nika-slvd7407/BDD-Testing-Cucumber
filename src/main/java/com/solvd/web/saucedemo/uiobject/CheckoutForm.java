package com.solvd.web.saucedemo.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutForm extends AbstractUIObject {

    @FindBy(id = "first-name")
    public ExtendedWebElement inputName;

    @FindBy(id = "last-name")
    public ExtendedWebElement inputLastName;

    @FindBy(id = "postal-code")
    public ExtendedWebElement inputPostalCode;

    @FindBy(id = "continue")
    public ExtendedWebElement checkoutButton;

    public CheckoutForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getInputName() {
        return inputName;
    }

    public ExtendedWebElement getInputLastName() {
        return inputLastName;
    }

    public ExtendedWebElement getInputPostalCode() {
        return inputPostalCode;
    }

    public void writeName(String name) {
        inputName.click();
        inputName.type(name);
    }

    public void writeLastName(String lastName) {
        inputLastName.click();
        inputLastName.type(lastName);
    }

    public void writePostalCode(String postalCode) {
        inputPostalCode.click();
        inputPostalCode.type(postalCode);
    }

    public void pressCheckoutButton() {
        checkoutButton.hover();
        checkoutButton.click();
    }

}
