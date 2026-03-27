package com.solvd.web.saucedemo.db;

import com.solvd.web.saucedemo.model.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getOrdersByUserId(int userId);
}