# Dream Portal QA Automation 

## Project Overview
This project automates the testing of the **Dream Portal** web application. It verifies the dream diary entries, types of dreams (Good/Bad), and ensures data integrity on the portal.

## Tools & Frameworks
- **Java**  
- **Selenium WebDriver**  
- **TestNG** for assertions and test execution  
- **Page Object Model (POM)** design pattern  
- **Maven** for dependency management  

## Project Structure

├── src/
      main/
        java/
        com/
        assignment/
        pages/ # Page classes (HomePage, DreamDiaryPage, SummaryPage)
        utils/ # Utility class (AIClassifier)
       test/
       java/
       com/
       assignment/
       tests/ # Test classes (BaseTest, DreamPortalTest)
     pom.xml # Maven configuration
     testng.xml # TestNG suite
     README.md # Project documentation
## Features Tested
- Navigate to Dream Portal home page
- Open **My Dreams** section
- Validate total dream entries
- Verify dream types (Good/Bad) and their counts
- Ensure every row has 3 columns and no empty cells

## How to Run
1. Clone the repository:  
```bash
git clone https://github.com/lokesh2904/dream-portal-tests.git

2. Navigate to project folder and install dependencies:
  mvn clean install
3. Run tests using TestNG:
  mvn test
4. Test results and reports will be available in the test-output/ folder.

Notes
-  The framework uses Page Object Model for better readability and maintenance.

-  All tests are written using TestNG assertions.

-  AI classification is included as a bonus feature.

-  No hardcoded waits; WebDriver explicit waits are used for reliability.
