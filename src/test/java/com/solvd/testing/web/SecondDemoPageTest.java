package com.solvd.testing.web;

import com.solvd.web.saucedemo.page.CartPage;
import com.solvd.web.saucedemo.page.CheckoutPage;
import com.solvd.web.saucedemo.page.LoginPage;
import com.solvd.web.saucedemo.page.MainPage;
import com.solvd.web.saucedemo.uiobject.CartList;
import com.solvd.web.saucedemo.uiobject.CheckoutForm;
import com.solvd.web.saucedemo.uiobject.InventoryList;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getDriver;

public class SecondDemoPageTest extends AbstractTest {

    @Test(description = "test authentication with valid credentials")
    public void testValidLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getDriver();
        String url = R.CONFIG.get("saucedemo_url");

        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);
        MainPage mainPage = loginPage.login();

        softAssert.assertEquals(
                mainPage.isPageOpened(), true, "Main page is failed to open"
        );

        softAssert.assertAll();
    }

    @Test
    public void testPurchase() {
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);

        MainPage mainPage = loginPage.login();

        InventoryList inventory = mainPage.getInventoryList();

        List<String> expectedNames = new ArrayList<>();
        double expectedSum = 0;

        for (int i = 0; i < 2; i++) {
            inventory.addItem(i);
            expectedNames.add(inventory.getItemName(i));
            expectedSum += inventory.getItemPrice(i);
        }

        CartPage cartPage = inventory.openCart();
        CartList cart = cartPage.getCartList();

        double actualSum = 0;

        for (int i = 0; i < cart.size(); i++) {
            String name = cart.getItemName(i);
            actualSum += cart.getItemPrice(i);

            Assert.assertTrue(expectedNames.contains(name));
        }

        Assert.assertEquals(actualSum, expectedSum);
    }

}
