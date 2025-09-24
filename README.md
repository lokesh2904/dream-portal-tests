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

<img width="978" height="540" alt="image" src="https://github.com/user-attachments/assets/9af78748-8984-49e8-b401-2a6ed4049730" />

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
