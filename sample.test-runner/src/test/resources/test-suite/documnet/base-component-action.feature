Feature:  base .
  As a Tester
  I want used use the web site that Tools-QA to practice auto testing
  So that I must sign in to the web site first.


  @browser @bot-style
  Scenario Outline: Sign in to Tools-QA successful.(Bot style)
    Given an account is "<userName>" | "<password>"
    And open the url "<url>"
    When input "<userName>" into text-box that default text is "UserName"
    And input "<password>" into text-box that default text is "Password"
    And click the "Login" button
    Then the page redirected to "<profile-url>"

    Examples:
      | userName  | password      | url                   | profile-url |
      | AlanLuo   | Alan@123456   | {tools-qa}/login      | {tools-qa}/profile |

  @browser @page-object
  Scenario Outline: Sign in to Tools-QA successful.(Page object)
    Given an account is "<userName>" | "<password>"
    When I sign in to Tools-QA site
    Then the page redirected to "{tools-qa}/profile"

    Examples:
      | userName  | password    |
      | AlanLuo   | Alan@123456 |

