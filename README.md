# Technical Test
Cucumber Feature files have been created for API tests and Functional tests.Functional web UI automated test are executed on chrome browser. This a maven project and the framework generates test data eachtime before execution of the below API test scenarios  
 
1)	Fetch bulk record: all students in database for that class
2)	Fetch student record by student id

## System Requirements
1. Java 1.8 or higher
2. Maven  3.8.4 
3. Chrome browser

## Steps to Execute Test 
1. Download the repo from github
2. Execute the studentmgmt-0.0.1-SNAPSHOT.jar file before running the test
3. Open terminal (command prompt) and Navigate to folder which contains file pom.xml of this project
4. Type the following commands and press enter
 * mvn clean
 * mvn test
5. After Test Execution test execution report will be available in the target folder as Html and JSON file.  The path for report will be like below
    technicaltest --> technicaltest --> target --> HtmlReports.html or cucumber.json
6. Open the HtmlReports.html in any web browser like chrome or microsoft edge

## Tools used
JAVA, Maven, RestAssured, JUnit, Cucumber, Selenium 
    
    
