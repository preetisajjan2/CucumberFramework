Feature: Search and Place the order for product

  @SearchProd
  Scenario Outline: Search with multiple products
    Given User is on Greencart landing page
    When user searched  with Shortname <name> and extcated actual name of product
    Then user searched for <name> same shortname in offers page to check if product exist
    And validate both the name matches

    Examples:
      | name |
      | Tom  |
      | Str  |
      | Beet |
