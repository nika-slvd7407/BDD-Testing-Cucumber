package com.solvd.web.saucedemo.db;

import com.solvd.web.saucedemo.model.User;

public interface UserMapper {
    User getUserByUsername(String username);
}