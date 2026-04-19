📌 SauceDemo Automation Framework

Automated Test Suite for SauceDemo (E‑Commerce Web Application)
This framework automates testing of the SauceDemo application using Java + Selenium + TestNG, with Allure reporting and CI/CD integration. It follows best practices in automation design: Page Object Model (POM), data-driven testing, parallel execution, and detailed failure reporting.

## 🏷️ Badges

[![Selenium Tests with Allure Report](https://github.com/MihaiS13/saucedemo-Automation/actions/workflows/selenium-allure.yml/badge.svg)](https://github.com/MihaiS13/saucedemo-Automation/actions/workflows/selenium-allure.yml)  
[![Allure Report](https://img.shields.io/badge/Allure-Report-blue)](https://mihais13.github.io/saucedemo-Automation/)  

⚠ Allure automatically captures screenshots on every failed test in the @AfterMethod
![Allure Test Report](allure-screenshot.png)

---

## ⚙️ Tech Stack

| Technology / Tool       | Purpose                                                    |
| ----------------------- | ---------------------------------------------------------- |
| Java                    | Main programming language                                  |
| Selenium WebDriver      | UI automation                                              |
| TestNG                  | Test runner and suite management                           |
| Maven                   | Build & dependency management                              |
| Allure Reports          | Detailed reporting, including screenshots for failed tests |
| JSON                    | Data-driven testing (test data)                            |
| GitHub Actions          | CI/CD and automated test execution                         |
| Branch `parallel-tests` | Parallel test execution for optimization                   |


---

## 📂 Project Structure

```
saucedemo-Automation/
├── src
│   ├── main/java
│   │   ├── driver/       # WebDriver Factory & Wait utils
│   │   ├── pages/        # Page Object Model classes
│   │   │   └── BasePage.java # BasePage: reusable methods (click, type, getText, select)
│   │   └── testData/     # JSON test data & classes
│   └── test/java
│       ├── tests/        # Test classes
│       └── BaseTests.java # Base test setup with driver, waits, Allure screenshots
├── pom.xml                # Maven configuration
├── testng.xml             # TestNG suite (parallel-enabled)
└── README.md
```
📐 BasePage – Code Reusability & Abstraction

To reduce code duplication and improve maintainability, the framework uses a BasePage class that:

Encapsulates common WebDriver actions like click, type, getText, isDisplayed, and dropdown selection.
Integrates WaitUtils to ensure elements are visible before interacting.
Serves as a parent class for all Page Objects, promoting clean and reusable Page Object Model design.

This makes adding new pages and tests much faster while keeping the framework scalable and maintainable.

---

🧪 Test Coverage

13 automated test scenarios covering critical user flows across login, cart, and checkout.
Reduced test execution time by 40% (from 95s to 57s) through parallel execution on 3 threads.

- **Login** – positive, negative, and locked user scenarios (3 scenarios)
- **Cart functionality** – add/remove items, validations
- **Checkout** – end-to-end checkout scenarios with 3 invalid data cases via TestNG @DataProvider
- **Data-driven testing** – TestNG @DataProvider for checkout edge cases (invalid name, email, postal code) + JSON files for user data
- **Parallel execution** – 3 threads, reduces runtime by 40% (95s → 57s) with thread-safe ThreadLocal WebDriver
- **Allure reporting** – automatically captures screenshots in @AfterMethod for failed tests

**Sample test flows:**

- Login → Add item → Checkout → Order confirmation
- Login → Invalid credentials → Error message displayed
- Locked user login → Proper error displayed
- Checkout → Invalid name/email/postal code → Validation error (data-driven)

---

## 🚀 Setup & Execution

1️⃣ Clone Repository

git clone https://github.com/MihaiS13/saucedemo-Automation.git

cd saucedemo-Automation

2️⃣ Compile & Run Tests

mvn clean compile

mvn clean test

TestNG will execute tests according to the suite defined in testng.xml.

3️⃣ Allure Reporting

After test execution:

allure generate target/allure-results --clean

allure open

Allure reports include:

Executed test cases and their statuses
Trends and statistics
Screenshots automatically captured for failed tests (captured in @AfterMethod)
![Allure Test Report](allure-screenshot.png)

🔧 Parallel Testing

The TestNG suite (testng.xml) is configured for parallel execution on 3 threads:

<suite name="SauceDemo Suite" parallel="methods" thread-count="3">
    <test name="All Tests">
        <packages>
            <package name="test"/>
        </packages>
    </test>
</suite>

- Reduces overall test execution time by 40% (from 95s to 57s)
- Each test runs independently using ThreadLocal WebDriver
- Branch dedicated for parallel tests: parallel-tests

🔹 CI/CD (GitHub Actions)
Tests run automatically on each push or pull request
Generates Allure report automatically
Workflow tested on Windows and Linux

[![Selenium Tests with Allure Report](https://github.com/MihaiS13/saucedemo-Automation/actions/workflows/selenium-allure.yml/badge.svg)](https://github.com/MihaiS13/saucedemo-Automation/actions/workflows/selenium-allure.yml) 

💡 Best Practices Demonstrated
Page Object Model (POM) design
"Data-driven testing using TestNG @DataProvider and JSON files"
Parallel execution using TestNG and ThreadLocal WebDriver
Detailed reporting with screenshots
CI/CD automation via GitHub Actions

📌 Conclusion

This project is a professional automation framework suitable for:

Showcasing in CV or LinkedIn
Demonstrating end-to-end test automation skills
Parallel testing & data-driven scenarios
Continuous Integration with automated reporting

Key Highlights for recruiters:

End-to-end test automation
Parallel execution & JSON data-driven testing
CI/CD integrated with Allure reporting
Scalable and maintainable automation framework
