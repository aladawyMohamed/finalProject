@smoke
Feature: F04_Search | users can search for product

Scenario Outline:  user could search for product using product name
  Given user is on the home page
  When user enter "<product name>" on the searchBox
  And user clicks on search button
  Then results are displayed for product name "<product name>"
  Examples:
    |product name|
    |book|
    |laptop|
    |nike|

  Scenario Outline:  user could search for product using product sku
    Given user is on the home page
    When user enter "<sku>" on the searchBox
    And user clicks on search button
    Then results are displayed for product sku "<sku>"
    Examples:
      | sku |
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
