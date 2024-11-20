@smoke
Feature: F05_hoverCategories | users can open sub-category page using hover action
  Scenario: user could open sub-category page
    Given user is on the home page
    When user hover on one random category of the main categories
    And user select random sub category
    Then sub category page is opened