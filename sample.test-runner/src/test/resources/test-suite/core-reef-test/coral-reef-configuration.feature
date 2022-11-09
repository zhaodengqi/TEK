
Feature: coral reef configuration
  As an auto tester
  I want access config file in my code
  So that ... ...

  @demo-case
  Scenario Outline: Get configuration option.
    Given the config file name is "configuration.qa.json"
    When invoking function getOption with parameter is "<key>"
    Then the result should be "<value>"

    Examples:
      | key               | value |
      | driver-directory  | D:\\SeleniumDriver           |
      | default-wait-time | 5000           |


  @demo-case
  Scenario Outline: Get configuration sub-option.
    Given the config file name is "configuration.qa.json"
    When invoking function getSubOption with parameter is "<key>" | "<sub-key>"
    Then the result should be "<value>"

    Examples:
      | key   | sub-key       | value |
      | sites | default-site  | https://default-site.com     |
      | sites | tools-qa      | https://demoqa.com    |