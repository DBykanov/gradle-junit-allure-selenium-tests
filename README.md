# gradle-junit-allure-tests
note: allure is configured to use via allure CLI (tested with allure v. 2.13.6)
commands :
1. To run tests:
   - to run all tests: ./gradlew clean test
   - To run particular tests: ./gradlew clean test --tests CalcTests
2. To generate allure report and open it : allure serve build/allure-results
