Feature: Validate login of registered users

  As a user of the demoblaze store
  I want to login
  To verify the email with which I logged in

  Background: Opens the browser demoblaze home page
    Given Camilo opens the browser in the home page


  @Login @Regression
  Scenario Outline: Login with correct credentials
    When he writes his credentials, <email> and <password>
    Then he should see his <email> when logging in
    And he closes the browser
    Examples:
      | email                | password   |
      | mamianauto@gmail.com | mamianauto |
      | mamianauto@gmail.com | mamianauto |