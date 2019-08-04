@category
Feature: category for home
  As a customer
  I want to filter the search results
  So that i get refined products

  @sri1
  Scenario:  Search for home products
    Given I am  Homepage
    When I search for a "home"
    And I select category filters as "Sofas"
    And I select category price Sofa filters as "Fabric"
    Then I should be able to see the respective product

  @sri2
  Scenario:  Search for home products
    Given I am  Homepage
    When I search for a "home"
    And I select category filters as "Sofas"
    And I select category colour Sofa filters as "Greys"
    Then I should be able to see the respective product

