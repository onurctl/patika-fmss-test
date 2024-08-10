Feature: User login

  # Case_01_01 - valid login: ..........................................................................................

  @login
  Scenario Outline: Login with valid credentials
    Given User is on the login page
    When User enter valid username "<username>" and password "<password>"
    And User submit the login form
    Then User should be redirected to the dashboard page
    Examples:
         | username      | password     |
         | Admin         | admin123     |

  # Case_01_02 - invalid login: ........................................................................................

  @login
  Scenario Outline: Login with invalid credentials
    Given User is on the login page
    When User enter invalid username "<username>" and password "<password>"
    And User submit the login form
    Then User see the error message
    Examples:
      | username      | password     |
      | Adm           | ad12         |


