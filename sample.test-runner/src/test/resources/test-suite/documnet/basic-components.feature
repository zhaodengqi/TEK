Feature: Basic web UI components.

  As a junior tester.
  I want to have some basic test components (ex: input box, button, checkbox, etc...).
  So that I can easily write page objects.

  @browser
  Scenario: Web button function
  You can use the setLocator method to set the positioning information of an element,just like this:
  ==> objButton.setLocator(LocatorType.XPATH,"//button[text()='Double Click Me']")
    Given open the url "{tools-qa}/buttons"
    * Inject the "WebButton" object in the constructor
    When use 'doubleClick' method of object click the "Double Click Me" button
    And use 'click' method of object click the "Click Me" button
    And use 'rightClick' method of object click the "Right Click Me" button
    Then verify then click action was successful

