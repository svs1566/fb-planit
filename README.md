# PlanIT Consulting
## Facebook web automation test 

## Built With

* [Cucumber](https://docs.cucumber.io/guides/bdd-tutorial/) – BDD tests
* [Selenium](https://www.seleniumhq.org/) – web automation
* [Page Object Model](https://www.seleniumhq.org/docs/06_test_design_considerations.jsp) – design pattern to abstract page behaviour
* [Spring Boot](http://spring.io/projects/spring-boot) – cleaner code
* [mockNeat](http://https://www.mockneat.com/) - random data generator library

## Set up
### Install 
   * JDK 8+ version
   * Apache maven. version used to build apache-maven-3.6.1
   
### Run *mvn clean install* on a terminal
## Run feature files
#### Open terminal and cd to project root /fb-planit and run *mvn -Dtest=AutomationTestRunner test*

### Maintenance & Assumptions
1. Add features under resources folder and follow the Page Object Design Pattern.
2. Signed up users using randomly generated data
3. Verified logged in user successfully, to further verify their identity either through a mobile or email secure code.  
