@API
Feature: Delete users
  As the owner of the product
  I want to delete users from database
  So I can manage users in a database

  Scenario: Delete a created user
    Given the user has been created
      | name | job      | salary |
      | Luis | Engineer | 10000  |
    When I delete the user in the platform
    Then the user will be deleted from the database