Feature: User Search

  # Case_02_01 - search 1: .............................................................................................

  @search
  Scenario: Invalid search on the Time page
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User click the Time button
    And User enter employee name "CrazyBeaver" on the Time page
    When User click the View Button on Time Page
    Then User see the error message on Time page

  # Case_02_02 - search 2: .............................................................................................

  @search
  Scenario: Search with username on the Admin page
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User click the Admin button
    And User enter username "Admin" on the Admin Page
    When User click the Search button on Admin Page
    Then User see the search results with the name of "Admin" on Admin Page

  # Case_02_03 - search 3: .............................................................................................

  @search
  Scenario: Verify search results count on Side Panel
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User search for "en" on the Side Panel
    Then User should see 1 results on Side Panel

  # Case_02_04 - search 4: .............................................................................................

  @search
  Scenario: Complete text search and verify on Side Panel
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User search for "Claim" on the Side Panel
    Then User should see the "Claim" on the Side Panel

  # Case_02_05 - search 5: .............................................................................................

  # dropdown:
  @search
  Scenario: Search for a record that is not in the results of the Directory page
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User click Directory Button
    And User choose an option "New York Sales Office" from the dropdown menu and click Search button on the Directory Page
    Then User should see the result "No Records Found" on Directory Page

  # Case_02_06 - search 6: .............................................................................................

  @search
  Scenario: Verify the total number of results on the Recruitment page
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User click the Recruitment button
    When User click the Search button on Recruitment Page
    Then Use see the total number "60" of results on the Recruitment page

  # Case_02_07 - search 7: .............................................................................................

  # negative test:
  @search
  Scenario: Verify a record that is not on the PIM page with a negative test
    Given User is on the login page
    When User enter valid username "Admin" and password "admin123"
    And User submit the login form
    Then User should be redirected to the dashboard page
    #
    When User click the PIM button
    And User enter ID "o012" on PIM Page
    When User click the Employee Search button on PIM page
    Then User see the PIM search results

