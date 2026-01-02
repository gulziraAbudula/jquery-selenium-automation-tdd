# 🧪 jQuery Selenium Automation TDD Framework

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)
![Selenium](https://img.shields.io/badge/Selenium-4.29-green?style=flat-square)
![TestNG](https://img.shields.io/badge/TestNG-7.9-blue?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.9-lightblue?style=flat-square)

Selenium TDD automation framework for jQuery UI components. Built with Java, Maven, TestNG using **Page Object Model** with parallel execution, Log4j2 logging, and ExtentReports.

---

## 📋 Table of Contents

- [Quick Start](#quick-start)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Running Tests](#running-tests)
- [Usage Guide](#usage-guide)
- [FAQ](#faq)
- [Contributing](#contributing)
- [License](#license)

---

## 🚀 Quick Start

```bash
# Clone and setup
git clone https://github.com/gulziraAbudula/jquery-selenium-automation-tdd.git
cd jquery-selenium-automation-tdd
mvn clean install

# Run tests
mvn clean test                           # Chrome (default)
mvn clean test -Dbrowser=firefox         # Firefox
mvn test -Dparallel=methods -DthreadCount=4  # Parallel (4 threads)
```

View reports: `open extentReports/myExtentReport*.html`

---

## ✨ Features

- 🎯 **Page Object Model** - Clean architecture with separated page logic
- ⚡ **Parallel Execution** - Run tests concurrently (up to 8 threads)
- 📊 **ExtentReports** - Beautiful HTML reports with screenshots
- 📝 **Log4j2 Logging** - Comprehensive logging for debugging
- 🌐 **Cross-browser Testing** - Chrome, Firefox, Edge support
- 🔄 **CI/CD Ready** - Jenkins & GitHub Actions compatible
- 📦 **Maven** - Dependency management & build automation
- 🧪 **TDD Principles** - Test-driven development approach
- 🏗️ **Modular Architecture** - Organized by functional modules

---

## 📋 Prerequisites

- **Java 21+** - [Download JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- **Maven 3.9+** - [Download Maven](https://maven.apache.org/download.cgi)
- **Git** - [Download Git](https://git-scm.com/)
- **Browsers** - Chrome or Firefox (latest)

> **Note:** WebDriverManager automatically downloads the correct driver version. No manual setup needed!

---

## 📁 Project Structure

```
jquery-selenium-automation-tdd/
│
├── src/test/
│   ├── java/com/automation/jQuery/
│   │   ├── bases/
│   │   │   ├── PageBase.java              # Base page object methods
│   │   │   ├── TestBase.java              # Base test setup/teardown
│   │   │   └── TestListener.java          # ExtentReports listener
│   │   │
│   │   ├── pages/                         # Page Objects (organized by module)
│   │   │   ├── interactionsModule/
│   │   │   │   ├── DragAndDropPage.java
│   │   │   │   ├── DroppablePage.java
│   │   │   │   └── ResizablePage.java
│   │   │   ├── widgetsModulePtOne/
│   │   │   │   ├── AccordionPage.java
│   │   │   │   ├── AutocompletePage.java
│   │   │   │   └── DatepickerPage.java
│   │   │   └── widgetsModulePtTwo/
│   │   │       ├── DialogPage.java
│   │   │       └── TabsPage.java
│   │   │
│   │   ├── tests/                         # Test classes
│   │   │   ├── regression/
│   │   │   │   ├── interactionsModuleTests/
│   │   │   │   └── widgetsModulePtOneTests/
│   │   │   └── smoke/
│   │   │       └── widgetsModulePtTwoTests/
│   │   │
│   │   └── utility/                       # Utility classes
│   │       ├── dataRelated/
│   │       │   ├── JsonReaderUtil.java    # JSON data handling
│   │       │   └── XLReaderUtil.java      # Excel data handling
│   │       ├── reportRelated/
│   │       │   ├── Log4jManager.java      # Logging utilities
│   │       │   └── TestListener.java      # Test reporting
│   │       └── webActionRelated/
│   │           ├── BrowserUtil.java       # Browser initialization
│   │           ├── AssertUtil.java        # Custom assertions
│   │           ├── WaitForFileDownloadUtil.java
│   │           └── DragAndDropUtil.java
│   │
│   └── resources/
│       ├── locators/locators.xml          # Element locators
│       ├── testdata/
│       │   ├── test-data.json
│       │   └── test-data.xlsx
│       └── log4j2.properties              # Logger configuration
│
├── runner/                                 # TestNG suite files
│   ├── regression/
│   │   ├── interactionRunner.xml
│   │   └── widgetsModulePtOneRunner.xml
│   └── smoke/
│       └── widgetsModulePtTwoRunner.xml
│
├── extentReports/                         # Test reports (auto-generated)
├── Screenshots/                           # Test failure screenshots
├── logs/                                  # Application logs
├── docs/                                  # Documentation
│   ├── SETUP.md
│   ├── TEST_EXECUTION.md
│   └── BEST_PRACTICES.md
├── .github/workflows/
│   └── test.yml                           # GitHub Actions workflow
├── .gitignore
├── pom.xml                                # Maven configuration
├── README.md
├── CHANGELOG.md
└── LICENSE
```

---

## 🏃 Running Tests

### Basic Commands

```bash
# Run all tests
mvn clean test

# Run on specific browser
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

### Run Specific Test Suites

```bash
# Interactions module (regression)
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/runner/regression/interactionRunner.xml

# Widgets module part one (regression)
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/runner/regression/widgetsModulePtOneRunner.xml

# Widgets module part two (smoke)
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/runner/smoke/widgetsModulePtTwoRunner.xml

# Multiple suites
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/runner/regression/interactionRunner.xml,src/test/resources/runner/regression/widgetsModulePtOneRunner.xml
```

### Parallel Execution

```bash
# Run tests with 4 parallel threads
mvn clean test -Dparallel=methods -DthreadCount=4

# Run tests with 8 parallel threads
mvn clean test -Dparallel=methods -DthreadCount=8

# Run test classes in parallel
mvn clean test -Dparallel=classes -DthreadCount=4
```

### Combined Examples

```bash
# Firefox with parallel execution (4 threads)
mvn clean test -Dbrowser=firefox -Dparallel=methods -DthreadCount=4

# Specific suite on Firefox in parallel
mvn test \
  -Dbrowser=firefox \
  -Dsurefire.suiteXmlFiles=src/test/resources/runner/regression/interactionRunner.xml \
  -Dparallel=methods \
  -DthreadCount=4

# All tests on Chrome with maximum parallel threads
mvn clean test -Dbrowser=chrome -Dparallel=methods -DthreadCount=8
```

### View Test Reports

```bash
# ExtentReports (Rich HTML report with screenshots)
open extentReports/myExtentReport*.html      # macOS
start extentReports/myExtentReport*.html     # Windows

# TestNG Reports
open target/surefire-reports/index.html      # macOS
start target/surefire-reports/index.html     # Windows
```

---

## 🎯 Usage Guide

### Creating a New Page Object

Page Objects encapsulate the elements and actions of a web page:

```java
package com.automation.jQuery.pages.interactionsModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.By;

public class DragAndDropPage extends PageBase {
    
    // Element locators
    private By dragItem = By.id("draggable");
    private By dropZone = By.id("droppable");
    private By successMessage = By.xpath("//p[text()='Dropped!']");
    
    // Page actions
    public void dragAndDropItem() {
        logger.info("Dragging item to drop zone");
        dNdUtil.dragNdrop(dragItem, dropZone);
    }
    
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
    
    // Fluent interface for method chaining
    public DragAndDropPage verifyDropped(String expectedMsg) {
        assertUtil.verifyMsg(successMessage, expectedMsg);
        logger.info("Verified: " + expectedMsg);
        return this;
    }
}
```

### Writing a Test Case

Tests are written using TestNG annotations following Arrange-Act-Assert pattern:

```java
package com.automation.jQuery.tests.regression.interactionsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.interactionsModule.DragAndDropPage;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
    
    @Test(description = "Verify user can drag and drop an item successfully")
    public void testDragAndDropFunctionality() {
        // Arrange
        DragAndDropPage page = new DragAndDropPage();
        String expectedMessage = "Dropped!";
        
        // Act
        page.dragAndDropItem();
        
        // Assert
        page.verifyDropped(expectedMessage);
    }
    
    @Test(description = "Verify multiple drag and drop operations")
    public void testMultipleDragOperations() {
        DragAndDropPage page = new DragAndDropPage();
        
        // Method chaining for fluent interface
        page.dragAndDropItem()
            .verifyDropped("Dropped!")
            .dragAndDropItem()
            .verifyDropped("Dropped!");
    }
}
```

### Using Element Locators from XML

Store locators in `src/test/resources/locators/locators.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Pages>
    <DragAndDropPage>
        <dragItem>//div[@id='draggable']</dragItem>
        <dropZone>//div[@id='droppable']</dropZone>
        <successMsg>//p[text()='Dropped!']</successMsg>
    </DragAndDropPage>
</Pages>
```

Load in your Page Object:

```java
Document document = xmlReader.getData("/src/test/resources/locators/locators.xml");
private By dragItem = By.xpath(document.selectSingleNode("//Pages/DragAndDropPage/dragItem").getText());
```

### Reading Test Data

**From Excel:**
```java
String username = xlRead.readCell("test-data.xlsx", 0, 1, 0);
String password = xlRead.readCell("test-data.xlsx", 0, 2, 0);
```

**From JSON:**
```java
String apiUrl = jsonUtil.getJsonValue("config.json", "api.baseUrl");
```

---

## ⚙️ Configuration

### Browser Setup (TestBase.java)

```java
@BeforeMethod
public void beforeEachMethod() {
    String browser = System.getProperty("browser", "chrome");
    System.out.println("Starting browser: " + browser);
    
    driver = BrowserUtil.startBrowser(browser);
    driver.get("https://jqueryui.com/");
}

@AfterMethod
public void afterEachMethod() {
    if (driver != null) {
        driver.quit();
    }
}
```

### Log4j2 Configuration (log4j2.properties)

```properties
status = warn
name = Log4j2Config

# Console appender
appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n

# File appender
appender.file.type = File
appender.file.name = LOGFILE
appender.file.fileName = logs/automation.log
appender.file.layout.type = PatternLayout
appender.file.layout.pattern = %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n

# Root logger
rootLogger.level = info
rootLogger.appenderRef.stdout.ref = STDOUT
rootLogger.appenderRef.file.ref = LOGFILE
```

### TestNG Suite Configuration Example

Create `runner/regression/interactionRunner.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Interactions Module Suite" parallel="methods" thread-count="4">
    <test name="Drag and Drop Tests">
        <classes>
            <class name="com.automation.jQuery.tests.regression.interactionsModuleTests.DragAndDropTest"/>
            <class name="com.automation.jQuery.tests.regression.interactionsModuleTests.ResizableTest"/>
        </classes>
    </test>
</suite>
```

---

## 📊 Test Reports

### ExtentReports

After test execution, a comprehensive HTML report is generated automatically.

**Location:** `extentReports/myExtentReport[timestamp].html`

**Includes:**
- ✅ Test execution summary (Pass/Fail/Skip statistics)
- 📊 Visual charts and timeline
- 📸 Screenshots on test failure
- 📝 Detailed logs and stack traces
- ⏱️ Test execution duration
- 🏷️ Test categories and tags

### TestNG Reports

Default reports in `target/surefire-reports/`:
- `index.html` - Main report
- `emailable-report.html` - Email-friendly version

### Application Logs

Logs stored in `logs/automation.log` with complete execution details.

---

## ❓ FAQ & Troubleshooting

**Q: Tests fail with "ChromeDriver not found"**

A: WebDriverManager handles this automatically. If issues persist:
```bash
mvn clean install -U
mvn test -Dbrowser=chrome
```

**Q: How do I run only regression tests?**

A: Use the specific suite file:
```bash
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/runner/regression/interactionRunner.xml
```

**Q: Can I run tests on Firefox?**

A: Yes! Use the browser parameter:
```bash
mvn clean test -Dbrowser=firefox
```

**Q: How do I run tests in parallel?**

A: Use the parallel configuration:
```bash
mvn clean test -Dparallel=methods -DthreadCount=4
```

**Q: Where are the test reports?**

A: Two locations:
- ExtentReports (Rich HTML): `extentReports/myExtentReport*.html`
- TestNG Reports: `target/surefire-reports/index.html`

**Q: How do I add a new test case?**

A: Follow these steps:
1. Create a new Page Object in `src/test/java/com/automation/jQuery/pages/`
2. Define element locators using `By` class
3. Create a test class in `src/test/java/com/automation/jQuery/tests/`
4. Extend `TestBase` and write test methods using TestNG annotations
5. Add test class to appropriate TestNG suite XML file in `runner/`
6. Run tests: `mvn clean test`

**Q: How do I update element locators?**

A: Two options:

Option 1 - Using locators.xml:
```xml
<Pages>
    <YourPage>
        <element>//xpath/to/element</element>
    </YourPage>
</Pages>
```

Option 2 - Direct in Page Object:
```java
private By element = By.xpath("//xpath/to/element");
```

**Q: Tests are slow. How can I speed them up?**

A: Use parallel execution with more threads:
```bash
mvn clean test -Dparallel=methods -DthreadCount=8
```

**Q: SLF4J warning: "No SLF4J providers were found"**

A: Already fixed in pom.xml with Log4j2 SLF4J binding. If persists:
```bash
mvn clean install -U
```

**Q: ExtentReports not generating**

A: Ensure `@BeforeSuite` is calling `onExtentSetup()`:
```java
@BeforeSuite
public void beforeEachSuite() {
    onExtentSetup();  // Initialize ExtentReports
}
```

**Q: Jenkins job failing with path issues**

A: Update suite file paths in pom.xml to use full paths:
```xml
<suiteXmlFile>src/test/resources/runner/regression/interactionRunner.xml</suiteXmlFile>
```

---

## 🤝 Contributing

We welcome contributions! Please follow these steps:

### 1. Fork the Repository
Click the "Fork" button on GitHub to create your own copy.

### 2. Create a Feature Branch
```bash
git checkout -b feature/your-amazing-feature
```

### 3. Add Your Changes
Write test cases following the existing patterns:
- Create Page Objects for new pages
- Write test cases using TestNG
- Update locators.xml for new elements
- Include meaningful comments

### 4. Ensure Tests Pass
```bash
mvn clean test
```

### 5. Commit with Meaningful Messages
```bash
git commit -m "feat: Add new test case for Accordion widget"
git commit -m "fix: Update broken XPath locator"
git commit -m "docs: Add setup instructions"
```

### 6. Push to Your Branch
```bash
git push origin feature/your-amazing-feature
```

### 7. Submit a Pull Request
- Go to GitHub and click "New Pull Request"
- Describe your changes clearly
- Reference any related issues

### Contribution Guidelines
- ✅ Follow existing naming conventions
- ✅ Write meaningful commit messages
- ✅ Add Page Objects for new pages
- ✅ Include test cases for new features
- ✅ Update locators.xml for new elements
- ✅ Ensure all tests pass before submitting PR
- ✅ Update documentation if needed

---

## 📄 License

This project is available for use under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 🎬 Video Walkthrough

Here's a walkthrough of a test run:

[![Video Walkthrough](jquery-tdd.gif "Test Execution Walkthrough")](jquery-tdd.gif)

---

## 📫 Support & Contact

- 🐛 Found a bug? [Open an issue](https://github.com/gulziraAbudula/jquery-selenium-automation-tdd/issues)
- 💡 Have a suggestion? [Start a discussion](https://github.com/gulziraAbudula/jquery-selenium-automation-tdd/discussions)
- ❓ Questions? Check the [FAQ section](#faq--troubleshooting) above

---

<div align="center">

**Made by [Gulzira Abdullah](https://github.com/gulziraAbudula)**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gulziraa/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/gulziraAbudula)

</div>
