package com.solvd.testing.web;

import com.solvd.web.saucedemo.page.CartPage;
import com.solvd.web.saucedemo.page.CheckoutPage;
import com.solvd.web.saucedemo.page.LoginPage;
import com.solvd.web.saucedemo.page.MainPage;
import com.solvd.web.saucedemo.uiobject.CartList;
import com.solvd.web.saucedemo.uiobject.CheckoutForm;
import com.solvd.web.saucedemo.uiobject.InventoryList;


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

    @Test(description = "test full purchase of multiple items")
    public void testPurchaseOfMultipleItems() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getDriver();
        String url = R.CONFIG.get("saucedemo_url");

        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);
        MainPage mainPage = loginPage.login();

        softAssert.assertEquals(
                mainPage.isPageOpened(), true, "Main page is failed to open"
        );

        List<String> itemToBuy = new ArrayList<>();
        InventoryList inventoryList = mainPage.getInventoryList();

        Thread.sleep(2000);
        inventoryList.addItem1();
        itemToBuy.add(inventoryList.getItem1Name());

        Thread.sleep(500);
        inventoryList.addItem2();
        itemToBuy.add(inventoryList.getItem2Name());

        Double totalCost = inventoryList.getItem1Cost() + inventoryList.getItem2Cost();

        CartPage cartPage = inventoryList.pressCart();
        CartList cartList = cartPage.getCartList();

        String cartName1 = cartList.getItemName(1);
        String cartName2 = cartList.getItemName(2);
        Double cartCost1 = cartList.getItemCost(1);
        Double cartCost2 = cartList.getItemCost(2);

        softAssert.assertTrue(
                itemToBuy.contains(cartName1), "Cart does not contains 1 item"
        );

        softAssert.assertTrue(
                itemToBuy.contains(cartName2), "Cart does not contains 2 item"
        );

        Double cartSum = cartCost1 + cartCost2;

        softAssert.assertEquals(
                totalCost, cartSum, "Cart sum is not equal"
        );

        CheckoutPage checkoutPage = cartList.pressCheckout();
        CheckoutForm checkoutForm = checkoutPage.checkoutForm;

        checkoutForm.writeName(R.TESTDATA.get("saucedemo_name"));
        checkoutForm.writeLastName(R.TESTDATA.get("saucedemo_last_name"));
        checkoutForm.writePostalCode(R.TESTDATA.get("saucedemo_zip"));
        checkoutForm.pressCheckoutButton();

        driver.findElement(By.id("finish")).click();
        String currentUrl = driver.getCurrentUrl();

        softAssert.assertTrue(currentUrl.equals("https://www.saucedemo.com/checkout-complete.html"), "Checkout failed and wont show complition");
        softAssert.assertAll();
    }

}
