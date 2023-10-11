Feature:Login in Jetpack Compose
  Perform login using username and password

  Scenario Outline:Successful Login
    Given I have a login Activity
    When I input email "<email>"
    And I input password "<password>"
    And I press login button
    Then it means login successful
    Examples:
      | email                    | password |
      | example123@gmail.com     | 1234567  |
      | example456@gmail.com     | 1231231  |
      | example789@gmail.com     | 1234567  |