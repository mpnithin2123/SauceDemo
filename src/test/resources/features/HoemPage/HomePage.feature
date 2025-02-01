Feature: This is to Test the Product Page for SauceDemo Website

  @HomePage
  Scenario Outline: Verify user is able to enter the product to a cart

    Given user navigates to the SauceDemo website
    And user enters the "<userName>" and "<password>"
    And clicks on login button
    When user clicks on Add to cart for Sauce Labs Backpack
    Then the product is added to the cart
    And close the browser

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @HomePage
  Scenario Outline: Verify user is able to remove the product from cart

    Given user navigates to the SauceDemo website
    And user enters the "<userName>" and "<password>"
    And clicks on login button
    And user clicks on Add to cart for Sauce Labs Backpack
    And the product is added to the cart
    When user clicks on Remove button for Sauce Labs Backpack
    Then Item is removed from the cart
    And close the browser

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |