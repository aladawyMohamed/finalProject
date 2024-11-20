@smoke
  Feature: F03_currencies | users can change the currency of product prices
    Scenario: user could change the currency
      Given user is on the home page
      When user select "Euro" currency from the currency dropdown list
      Then currency Symbol "€" is shown on the 4 products displayed in Home page