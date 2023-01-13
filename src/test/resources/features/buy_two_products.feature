Feature: Make a purchase of two products added to the cart

  As a registered user on the demoblaze website
  I want to buy two products
  To verify the purchase made

  Background: Opens the browser demoblaze home page
    Given Camilo opens the browser in the home page
    When he writes his credentials, mamianauto@gmail.com and mamianauto

  @PlaceOrder @Regression
  Scenario Outline: Buy two products in the demoblaze store
    When he adds two products to the cart
      | Product name one | <name1>  |
      | Price name one   | <price1> |
      | Product name two | <name2>  |
      | Price name two   | <price2> |
    Then he should see the total <value> of the products
    And he fills in the form to place an order
      | Name        | <name>       |
      | Country     | <country>    |
      | City        | <city>       |
      | Credit card | <creditCard> |
      | Month       | <month>      |
      | Year        | <year>       |
    Then he should see the confirmation message Thank you for your purchase!
    And he closes the browser
    Examples:
      | name1             | price1 | name2            | price2 | value | name   | country  | city       | creditCard | month | year |
      | Samsung galaxy s6 | 360    | Nokia lumia 1520 | 820    | 1180  | Camilo | Colombia | Bogota D C | 1234567890 | 12    | 2026 |
      | Samsung galaxy s6 | 360    | Nexus 6          | 650    | 1010  | Carlos | Ecuador  | Quito      | 2233665544 | 11    | 2028 |
