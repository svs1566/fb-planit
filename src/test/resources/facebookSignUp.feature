Feature:As an social media person, I want to sign up with facebook and create an account.

  Scenario Outline: : As a social media person I sign up with facebook.
    Given I navigate to facebook
    When I enter my firstname as '<firstname>'
    And I enter my surname as '<surname>'
    And I enter my mobile as '<mobile>'
    And I enter my password as '<password>'
    And I enter my birthday as '<birthday>'
    And I enter my birthmonth as '<birthmonth>'
    And I enter my birthyear as '<birthyear>'
    And I enter my gender as '<gender>'
    And I hit signup
    Then I confirm to have logged in successfully
    And I close the browser
    Examples:
      | firstname | surname | mobile     | password   | birthday | birthmonth | birthyear | gender |
      | sachin    | shinde  | 0422523151 | 123SSS     | 29       | Apr        | 1986      | male   |
      | sachin    | shinde  | 0422523152 | 123Sadsasd | 12       | Dec        | 1987      | male   |