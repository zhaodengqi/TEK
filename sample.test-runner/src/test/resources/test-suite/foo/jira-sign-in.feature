Feature:  Simple Demo to sign in the jira.
  As a Tester
  I want sign in to the jira.
  So that I can used jira to management our project.


  @demo-case @bot-style
  Scenario Outline: Sign in to jira successful.(Bot style)
    Given an account is "<userName>" | "<password>"
    And open the url "<url>"
    When input "<userName>" into textbox that default text is "输入电子邮件"
    And click the "继续" button
    Then the password textbox is display
    When input "<password>" into textbox that default text is "输入密码"
    And click the "登录" button
    Then the page redirected to "<atlassianHomeUrl>"

    Examples:
      | userName              | password     | url                            | atlassianHomeUrl            |
      | iteamalan@hotmail.com | North@123456 | https://id.atlassian.com/login | https://start.atlassian.com |

  @demo-case @page-object
  Scenario Outline: Sign in to jira successful.(Page object)
    Given an account is "<userName>" | "<password>"
    When I sign in to atlassian site
    Then the page redirected to "https://start.atlassian.com"

    Examples:
      | userName              | password       |
      | iteamalan@hotmail.com | North@123456 |

