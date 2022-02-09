@API
Feature: Create users
  As the owner of the product
  I want to create new users
  So I can persist the new users in a database

  Scenario: Create a new user
    Given "Pedro" is a "tester" with a salary of "6000"
    When I send the information to create the user in the platform
    Then the user will be created