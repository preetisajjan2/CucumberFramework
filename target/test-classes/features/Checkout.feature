Feature: Place the order for the Products

  @PlaceOrder
  Scenario Outline: Search with multiple products
    Given User is on Greencart landing page
    When user searched  with Shortname <name> and extcated actual name of product
    And Added "3" items of the selected product to cart
    Then user proceed to checkbox and validate the <name> items in checkout page
    And verify user has ability to enter promo code and plce the order

    Examples:
      | name |
      | Tom  |
      | Cucu |
