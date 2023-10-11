Feature:Login In View
  Perform login using username and password

  Scenario Outline:Successful Login
    Given I have login Activity
    When I input an email "<email>"
    And I input a password "<password>"
    And I press the login button
    Then I should see the status error on the "<status>"
    Examples:
      | email                    | password | status  |
      | example123@gmail.com     | 1234567  | Success |
      | example456@gmail.com     | 1231231  | Failed  |
      | example123@gmail.com     | 1234567  | Success |