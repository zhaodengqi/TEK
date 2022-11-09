Feature:  Simple Demo to sign in the jira.
  As a Tester
  I want to test the submit function of the TextBox page
  So that demonstrate how the bot-style mode is coded

  @browser
  Scenario Outline:  Submit data in TextBox page
    Given  open the url "<url>"
    And input "<full name>" into text-box that default text is "Full Name"
    And input "<email>" into text-box that default text is "name@example.com"
    When click the "Submit" button
    Then some check

    Examples:
      | full name  | email      | url                   |
      | AlanLuo   | Alan@123456.com   | {tools-qa}/text-box      |

  @browser
  Scenario:  Use Web Driver
    Given open web site google
    When input "Auto Test" in search text box
    Then check search result
