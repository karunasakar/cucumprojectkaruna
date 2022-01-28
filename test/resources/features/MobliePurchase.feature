#Author: karunasakar1@your.domain.com
Feature: moblie purchase

  Scenario: moblie purchase validation
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile
    And user click on the mobile name
    Then user click on add to cart

  Scenario: moblie purchase validation one dim
    Given user launches flipkart application
    And user login by entering valid crendentials
    When user search mobile by one dim list
      | realme | IPhone | vivo |
    And user click on the mobile name
    Then user click on add to cart
