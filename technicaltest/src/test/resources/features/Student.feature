Feature: Get student information from the system

  Scenario Outline: Sanity Test
    Given I am an authorised user
    Then I reach the endpoint with <param> for class

    Examples: 
      | param |
      | "FY"  |

  @Smoke
  Scenario Outline: Fetch all students
    Given I can hit the url with <param> for class
    Then I can verify the <status> for it
    And message contains <nationality> in record

    Examples: 
      | param | status | nationality |
      | "FY"  |    200 | "India"     |
      | "SY"  |    200 | "Belgium"  |
      | "TY"  |    200 | "Qatar"     |

  @Smoke
  Scenario Outline: Fetch students by  id
    Given I can retrive record <id> of the student

    Examples: 
      | id  |
      | 201 |
      | 205 |
