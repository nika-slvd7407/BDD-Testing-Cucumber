package com.solvd.web.saucedemo.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String zip;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
}