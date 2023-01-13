Feature: Calculate the value of two products

  As a registered user on the demoblaze website
  I add the value of two products
  To validate the value of the sum of the two products

  Background: Opens the browser demoblaze home page
    Given Camilo opens the browser in the home page
    When he writes his credentials, mamianauto@gmail.com and mamianauto

  @FullValue @Regression
  Scenario Outline: Validate the price of two products added to the cart
    When he adds two products to the cart
      | Product name one | <name1>  |
      | Price name one   | <price1> |
      | Product name two | <name2>  |
      | Price name two   | <price2> |
    Then he should see the total <value> of the products
    And he removes the products from the cart
    And he closes the browser
    Examples:
      | name1             | price1 | name2            | price2 | value |
      | Samsung galaxy s6 | 360    | Nokia lumia 1520 | 820    | 1180  |
      | Nexus 6           | 650    | Iphone 6 32gb    | 790    | 1440  |