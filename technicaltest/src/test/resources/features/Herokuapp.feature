Feature: Functional Login web test automation

  @Smoke
  Scenario: Login to Heroku app
    Given I navigate to Heroku website
    And I can click form authentication
    When I enter username and password
    Then I can login
