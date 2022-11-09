Feature:  base test.
  As a shopper
  I want can check pet prices and place an order online
  So that I don't have to go to distant offline stores


  @browser
  Scenario Outline: Buy a single pet.(draft version)
    Given a logged in pet-store user with: "<userName>" | "<password>"
    And search for "Bulldog" in the query box
    * add a male bulldog to cart
    When submit order with this information:
      | CardType   | MasterCard               |
      | CardNumber | 888 8888 8888 8888 |
      | ExpiryDate | 12/03              |
      | FirstName  | Alan               |
      | LastName   | Luo                |
      | Address1   | Address 1111       |
      | Address2   | Address 2222       |
      | City       | City 111           |
      | State      | State 1            |
      | Zip        | 4000               |
      | Country    | China              |

    Then check the order amount is <Amount>

    Examples:
      | userName | password | Amount |
      | Alan     | 123456   | 18.50 |

#  Scenario Outline: Buy a single pet.(Specification by Example)


