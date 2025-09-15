@Suite
  @Smoke
  @Regress
 # аннотации для группировки сценариев (например, @Smoke, @API).

# описание функциональности (что тестируем).
Feature: Login functionality
  As a user
  I want to login to BookStack
  So that I can access my content

  # конкретный сценарий проверки.
  Scenario: Successful login with valid credentials
    Given User on the login page
    When User enter valid admin credentials
    And User click login button
    Then User should be redirected to dashboard


  Scenario: Check massage about empty password
    Given User on the login page
    When User input email
    And User click login button
    Then User see error about empty password