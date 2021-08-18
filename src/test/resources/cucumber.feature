Feature: As a user i need to create a account in ecom website

  Scenario Outline: To check the feature of account creation in ecom website with valid inputs
    Given Launch the web application
    When Navigate to My Account and click Register
    And Enter "<First Name>" "<Last Name>" "<Email>" "<Telephone>" "<password>" "<confirmpassword>" and click continue
    Then User should successfully created a account

    Examples: 
      | First Name | Last Name | Email            | Telephone  | Password | confirmpassword |
      | Gnana      | Sekaran   | gnanass123456@gmail.com | 1234578999 | 1234    | 1234           |
