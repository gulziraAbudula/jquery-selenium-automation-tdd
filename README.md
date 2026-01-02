<div align="center">
Show Image
Show Image
Show Image
Show Image
Show Image
Show Image
Selenium-based test-driven automation framework for jQuery UI components. Built with Java, TestNG, and Maven using the Page Object Model design pattern. Features parallel execution, Log4j2 logging, and ExtentReports for comprehensive test reporting.
Quick Start • Features • Documentation • Contributing
</div>

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Configuration](#configuration)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project provides a robust automation testing framework specifically designed for testing jQuery UI components using Selenium WebDriver. It follows Test-Driven Development (TDD) principles and implements the Page Object Model (POM) pattern for maintainable and scalable test automation.

## Features

- **Page Object Model (POM)**: Clean separation of test logic and page-specific code
- **TestNG Framework**: Powerful test configuration and parallel execution
- **Maven Build Tool**: Dependency management and build lifecycle
- **Parallel Execution**: Run tests concurrently for faster feedback
- **Log4j2 Logging**: Comprehensive logging for debugging and analysis
- **ExtentReports**: Rich HTML test reports with screenshots
- **jQuery UI Focus**: Specialized support for jQuery UI components
- **Cross-browser Testing**: Support for multiple browsers (Chrome, Firefox, Edge, etc.)

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher
- **Apache Maven**: Version 3.6 or higher
- **Web Browsers**: Chrome, Firefox, or other browsers you want to test on
- **WebDriver**: Appropriate drivers for your target browsers (ChromeDriver, GeckoDriver, etc.)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/gulziraAbudula/jquery-selenium-automation-tdd.git
   cd jquery-selenium-automation-tdd
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Configure WebDriver**:
   - Download the appropriate WebDriver executable for your browser
   - Add the WebDriver location to your system PATH, or
   - Specify the driver path in your test configuration

## Project Structure

```
jquery-selenium-automation-tdd/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── automation/
│       │           └── jQuery/
│       │               ├── bases/                      # Base classes
│       │               │   ├── PageBase.java
│       │               │   └── TestBase.java
│       │               ├── pages/                      # Page Object classes
│       │               │   ├── Homepage.java
│       │               │   ├── effectsModule/          # Effects module pages
│       │               │   ├── interactionsModule/     # Interactions module pages
│       │               │   ├── utilityModule/          # Utility module pages
│       │               │   ├── widgetsModulePtOne/     # Widgets module part 1 pages
│       │               │   └── widgetsModulePtTwo/     # Widgets module part 2 pages
│       │               ├── tests/                      # Test classes
│       │               │   ├── regression/             # Regression test suites
│       │               │   │   ├── effectsModuleTests/
│       │               │   │   ├── interactionsModuleTests/
│       │               │   │   └── widgetsModulePtOneTests/
│       │               │   └── smoke/                  # Smoke test suites
│       │               │       ├── utilityModuleTests/
│       │               │       └── widgetsModulePtTwoTests/
│       │               └── utility/                    # Utility classes
│       │                   ├── dataRelated/            # Data handling utilities
│       │                   ├── reportRelated/          # Reporting utilities
│       │                   └── webActionRelated/       # Web interaction utilities
│       └── resources/
│           ├── locators/
│           │   └── locators.xml                        # Element locators
│           └── log4j2.properties                       # Log4j2 configuration
├── runner/                                             # TestNG runner files
│   ├── regression/
│   │   ├── interactionRunner.xml
│   │   └── widgetsModulePtOneRunner.xml
│   └── smoke/
│       └── widgetsModulePtTwoRunner.xml
├── Screenshots/                                        # Test screenshots
├── extentReports/                                      # ExtentReports HTML reports
├── logs/                                               # Log files
├── pom.xml                                             # Maven configuration
└── README.md
```

## Usage

### Creating Page Objects

Page Objects encapsulate the elements and actions of a web page:

```java
public class JQueryUIPage {
    private WebDriver driver;
    
    @FindBy(id = "accordion")
    private WebElement accordion;
    
    public JQueryUIPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickAccordion() {
        accordion.click();
    }
}
```

### Writing Tests

Tests are written using TestNG annotations:

```java
public class JQueryUITest extends BaseTest {
    
    @Test
    public void testAccordionFunctionality() {
        JQueryUIPage page = new JQueryUIPage(driver);
        page.clickAccordion();
        // Add assertions
    }
}
```

## Running Tests

### Run all tests:
```bash
mvn clean test
```

### Run specific test suite:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run tests in parallel:
```bash
mvn clean test -Dparallel=methods -DthreadCount=4
```

### Run tests for specific browser:
```bash
mvn clean test -Dbrowser=chrome
```

## Configuration

### TestNG Configuration (testng.xml)

Configure test suites, parallel execution, and parameters:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="jQuery UI Test Suite" parallel="methods" thread-count="4">
    <test name="jQuery UI Tests">
        <classes>
            <class name="tests.JQueryUITest"/>
        </classes>
    </test>
</suite>
```

### Log4j2 Configuration

Customize logging levels and output formats in `log4j2.xml`:

```xml
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

## Reporting

### ExtentReports

After test execution, ExtentReports generates detailed HTML reports in the `test-output` directory. Open `ExtentReport.html` in a browser to view:

- Test execution summary
- Pass/fail statistics
- Screenshots of failures
- Detailed logs and stack traces
- Test execution timeline

### TestNG Reports

TestNG also generates default reports:
- `test-output/index.html`: Main report
- `test-output/emailable-report.html`: Email-friendly report

# Video Walkthrough

Here's a walkthrough of test run:

<img src='/jquery-tdd.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

# Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is available for use under the terms specified by the repository owner.
