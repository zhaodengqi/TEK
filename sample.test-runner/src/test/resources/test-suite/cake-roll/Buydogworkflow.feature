Feature:  base test.
  @browser
  Scenario Outline: Buy a male bulldog.(Bot style)
    Given Open Petstore Login page "<url>"
    And Input "<userName>" and "<password>"
    And Click Login Button
    And Wait until the main page return
    And Search and add bulldog to purchase
    And Check the content of the payment information
    Then check the order amount

    Examples:
      | userName | password | Amount |
      | Alan     | 123456   | 18.50  |
