@smoke
Feature: F08_Wishlist | users could add product to the wishlist

  Scenario : user could use wishlist button to add product to wishlist
    Given user is on the home page
    When user clicks on wishlist button on the product
    Then the success message "The product has been added to your wishlist" is displayed


  Scenario : user could find the wish product on the wishlist
    Given user is on the home page
    When user clicks on wishlist button on the product
    And user go to the wishlist page
    Then the wishlist should contains the added product