package com.solvd.testing;

import com.solvd.web.saucedemo.db.MyBatisUtil;
import com.solvd.web.saucedemo.db.OrderMapper;
import com.solvd.web.saucedemo.db.UserMapper;
import com.solvd.web.saucedemo.model.Order;
import com.solvd.web.saucedemo.model.User;
import com.solvd.web.saucedemo.page.CartPage;
import com.solvd.web.saucedemo.page.CheckoutPage;
import com.solvd.web.saucedemo.page.LoginPage;
import com.solvd.web.saucedemo.page.MainPage;
import com.solvd.web.saucedemo.uiobject.CheckoutForm;
import com.solvd.web.saucedemo.uiobject.InventoryList;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PurchaseSteps implements IDriverPool {

    private WebDriver driver;
    private User user;
    private List<Order> orders;
    private MainPage mainPage;

    @Given("user {string} exists in DB")
    public void loadUser(String username) {
        try (SqlSession session = MyBatisUtil.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);

            user = userMapper.getUserByUsername(username);
            orders = orderMapper.getOrdersByUserId(user.getId());
        }
    }

    @When("user logs in")
    public void login() {
        driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.getLoginForm().inputUsername(user.getUsername());
        loginPage.getLoginForm().inputPassword(user.getPassword());

        mainPage = loginPage.getLoginForm().pressLogin();
    }

    @And("adds all products from DB")
    public void addProducts() {
        InventoryList inventory = mainPage.getInventoryList();

        for (Order order : orders) {
            for (int i = 0; i < 6; i++) {
                if (inventory.getItemName(i).equals(order.getProductName().toLowerCase())) {
                    inventory.addItem(i);
                }
            }
        }
    }

    @And("proceeds to checkout")
    public void checkout() {
        CartPage cartPage = mainPage.getInventoryList().openCart();
        CheckoutPage checkoutPage = cartPage.getCartList().checkout();

        CheckoutForm form = checkoutPage.checkoutForm;
        form.writeName(user.getFirstName());
        form.writeLastName(user.getLastName());
        form.writePostalCode(user.getZip());
        form.pressCheckoutButton();
    }

    @Then("order should be successful")
    public void validate() {
        String url = driver.getCurrentUrl();
        if (!url.contains("checkout-step-two")) {
            throw new AssertionError("Checkout failed");
        }
    }
}