@smoke
Feature: F06_homeSliders | users could click on slider on homepage to go to the product page

  Scenario Outline:  slider is clickable on home page
    Given user is on the home page
    When user clicks on the slider "<slider>"
    Then product page "<product page>" is opened
    Examples:
      |slider| product page |
      |first| https://demo.nopcommerce.com/nokia-lumia-1020 |
      |second| https://demo.nopcommerce.com/iphone-6 |