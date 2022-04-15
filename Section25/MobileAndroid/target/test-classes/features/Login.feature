Feature: As an User, I Want to success Login, So that I can see my home page

  Scenario: As an User, I cannot Login because wrong email or password
    Given user on the login page
    When user input "bagasdwisaputra19@gmail.com" on email field
    And user input "password" on password field
    And user click login button
    Then user see error message "Wrong Email or Password"