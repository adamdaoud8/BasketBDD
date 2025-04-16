Feature: Create an account

  Scenario: successful login
    Given User is using "Edge" as a webb browser
    Given I have entered date of birth
    And I have entered first name "Adam"
    And I have entered last name "Daoud"
    And I have entered Email address "adam8@live.com"
    And I have confirmed Email address "adam8@live.com"
    And I have entered password "Tiger121"
    And I have retyped password "Tiger121"
    And I have checked box for marketing communications
    And I have checked box for Terms and Conditions
    And I have checked the box for age over 18
    And I have checked box for Code of Ethics
    When I press for confirm and join
    Then The application is successful

    Scenario: Last name missing
      Given User is using "Edge" as a webb browser
      Given I have entered date of birth
      And I have entered first name "Emil"
      And I have entered last name ""
      And I have entered Email address "emil1@live.com"
      And I have confirmed Email address "emil1@live.com"
      And I have entered password "emilclark"
      And I have retyped password "emilclark"
      And I have checked box for marketing communications
      And I have checked box for Terms and Conditions
      And I have checked the box for age over 18
      And I have checked box for Code of Ethics
      When I press for confirm and join
      Then Missing last name for the application

      Scenario: Password miss match
        Given User is using "Chrome" as a webb browser
        Given I have entered date of birth
        And I have entered first name "Jonas"
        And I have entered last name "Carlsson"
        And I have entered Email address "Jonas1@live.com"
        And I have confirmed Email address "Jonas1@live.com"
        And I have entered password "jonasjonas1"
        And I have retyped password "Jonasjonas"
        And I have checked box for marketing communications
        And I have checked box for Terms and Conditions
        And I have checked the box for age over 18
        And I have checked box for Code of Ethics
        When I press for confirm and join
        Then Password miss match for the application

        Scenario Outline: Terms and Conditions not confirmed
          Given User is using "Chrome" as a webb browser
          Given I have entered date of birth
          And I have entered first name "<Firstname>"
          And I have entered last name "<Lastname>"
          And I have entered Email address "<Email-address>"
          And I have confirmed Email address "<Email-address>"
          And I have entered password "<Password>"
          And I have retyped password "<Password>"
          And I have checked box for marketing communications
          And I have checked the box for age over 18
          And I have checked box for Code of Ethics
          When I press for confirm and join
          Then The box for Terms and Conditions is not checked

          Examples: Terms and Conditions not confirmed
            | Firstname | Lastname | Email-address    | Password |  |  |  |
            | Robert    | Miles    | Robert1@live.com | Robert1  |  |  |  |
