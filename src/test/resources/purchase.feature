Feature: Purchase products from DB

  Scenario: Purchase for first user
    Given user "standard_user" exists in DB
    When user logs in
    And adds all products from DB
    And proceeds to checkout
    Then order should be successful

  Scenario: Purchase for second user
    Given user "problem_user" exists in DB
    When user logs in
    And adds all products from DB
    And proceeds to checkout
    Then order should be successful