Feature: This is to Test the Login Page for SauceDemo Website

  @Login @PositiveScenario
  Scenario Outline: Verify if user is able to successfully login to the SauceDemo Page

    Given user navigates to the SauceDemo website
    When user enters the "<userName>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page
    And close the browser

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @Login @NegativeScenario
  Scenario Outline: Verify error message is displayed when user provides a invalid login credentials to the SauceDemo Page

    Given user navigates to the SauceDemo website
    When user enters an invalid "<userName>" and "<password>"
    And clicks on login button
    Then error message "<message>" is displayed to the user
    And close the browser

    Examples:
      | userName | password | message                                                                   |
      | userName | password | Epic sadface: Username and password do not match any user in this service |

  @Login @LocalStorageCheck
  Scenario Outline: Verify after login session username is stored in the cookie

    Given user navigates to the SauceDemo website
    When user enters the "<userName>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page
    And verify the cookie is storing the session username and it is same as the "<userName>" used for login
    And close the browser

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @Login @PositiveScenario
  Scenario: Verify the Login button and Login logo in SauceDemo Page

    Given user navigates to the SauceDemo website
    When user lands in the sign in page
    Then user is able to view the Login button as "Login" and Login logo as "Swag Labs"
