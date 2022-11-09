Feature: Show how to use ActionBot
  Simple demo about the functions of ActionBot.
  As an auto QA
  I want to use every function of ActionBot
  So that others could learn it


@browser @debug
  Scenario: auto tek working
    Given Open shinedo check login page
    When input username and password login shinedo
    And create new order in shined
#    Given Open Allegis check login page
#    When input username and password login Allegis
#    And create new order in Allegis
