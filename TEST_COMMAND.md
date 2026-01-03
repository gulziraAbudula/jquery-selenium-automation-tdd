# jQuery TDD Test Commands Documentation

This document outlines all available test execution scenarios for the jQuery TDD project.

## Quick Start

```bash
chmod +x run.sh
./run.sh <scenario>
```

## Local Browser Tests

Run tests on your local machine with installed browsers.

### Firefox Browser (Local)
```bash
./run.sh tdd-firefox
```
Runs TDD tests with Firefox browser locally on your machine.

**Maven Command:**
```
mvn clean test -Dbrowser=firefox -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Local development and testing on Firefox

---

### Chrome Browser (Local)
```bash
./run.sh tdd-chrome
```
Runs TDD tests with Chrome browser locally on your machine.

**Maven Command:**
```
mvn clean test -Dbrowser=chrome -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Local development and testing on Chrome

---

## Docker Container Tests

Run tests in Docker containers for consistent, isolated environments.

### Chrome in Docker
```bash
./run.sh tdd-chrome-docker
```
Runs TDD tests with Chrome in a Docker container.

**Maven Command:**
```
mvn clean test -Dbrowser=chrome -Dexecution.mode=docker -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Containerized testing, CI/CD pipelines, cross-environment consistency

---

### Firefox in Docker
```bash
./run.sh tdd-firefox-docker
```
Runs TDD tests with Firefox in a Docker container.

**Maven Command:**
```
mvn clean test -Dbrowser=firefox -Dexecution.mode=docker -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Containerized testing, CI/CD pipelines, cross-environment consistency

---

## Linux Platform Tests

Run regression tests on Linux platform with Docker.

### Chrome on Linux
```bash
./run.sh linux-chrome
```
Runs TDD tests on Linux platform with Chrome browser.

**Maven Command:**
```
mvn clean test -Dbrowser=chrome -Dexecution.mode=docker -Dplatform=linux -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing Linux compatibility with Chrome, Linux CI/CD pipelines

---

### Firefox on Linux
```bash
./run.sh linux-firefox
```
Runs TDD tests on Linux platform with Firefox browser.

**Maven Command:**
```
mvn clean test -Dbrowser=firefox -Dexecution.mode=docker -Dplatform=linux -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing Linux compatibility with Firefox, Linux CI/CD pipelines

---

## Windows Platform Tests

Run regression tests on Windows platform with Docker.

### Chrome on Windows
```bash
./run.sh windows-chrome
```
Runs TDD tests on Windows platform with Chrome browser.

**Maven Command:**
```
mvn clean test -Dbrowser=chrome -Dexecution.mode=docker -Dplatform=windows -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing Windows compatibility with Chrome, Windows CI/CD pipelines

---

### Firefox on Windows
```bash
./run.sh windows-firefox
```
Runs TDD tests on Windows platform with Firefox browser.

**Maven Command:**
```
mvn clean test -Dbrowser=firefox -Dexecution.mode=docker -Dplatform=windows -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing Windows compatibility with Firefox, Windows CI/CD pipelines

---

## Mac Platform Tests

Run regression tests on Mac platform with Docker.

### Chrome on Mac
```bash
./run.sh mac-chrome
```
Runs TDD tests on Mac platform with Chrome browser.

**Maven Command:**
```
mvn clean test -Dbrowser=chrome -Dexecution.mode=docker -Dplatform=mac -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing macOS compatibility with Chrome, Mac CI/CD pipelines

---

### Firefox on Mac
```bash
./run.sh mac-firefox
```
Runs TDD tests on Mac platform with Firefox browser.

**Maven Command:**
```
mvn clean test -Dbrowser=firefox -Dexecution.mode=docker -Dplatform=mac -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
```

**When to use:** Testing macOS compatibility with Firefox, Mac CI/CD pipelines

---

## Batch Operations

Run multiple test configurations at once.

### All Local Tests
```bash
./run.sh local-all
```
Runs all local browser tests sequentially:
1. TDD Firefox (local)
2. TDD Chrome (local)

**When to use:** Quick local testing before committing code

---

### All Docker Tests
```bash
./run.sh docker-all
```
Runs all Docker container tests sequentially:
1. TDD Chrome Docker
2. TDD Firefox Docker

**When to use:** Container-based testing in CI/CD pipelines

---

### All Linux Tests
```bash
./run.sh linux-all
```
Runs all Linux platform tests sequentially:
1. Linux Chrome
2. Linux Firefox

**When to use:** Comprehensive Linux platform testing

---

### All Windows Tests
```bash
./run.sh windows-all
```
Runs all Windows platform tests sequentially:
1. Windows Chrome
2. Windows Firefox

**When to use:** Comprehensive Windows platform testing

---

### All Mac Tests
```bash
./run.sh mac-all
```
Runs all Mac platform tests sequentially:
1. Mac Chrome
2. Mac Firefox

**When to use:** Comprehensive Mac platform testing

---

### All Platform Tests
```bash
./run.sh all-platforms
```
Runs all platform-specific tests sequentially:
1. All Linux tests
2. All Windows tests
3. All Mac tests

**When to use:** Full cross-platform regression testing

---

### All Tests
```bash
./run.sh all
```
Runs all available test configurations:
1. All local browser tests
2. All Docker container tests
3. All platform-specific tests (Linux, Windows, Mac)

**When to use:** Complete regression testing, pre-release validation, comprehensive testing

---

## Utility Commands

### Help
```bash
./run.sh help
```
Displays all available scenarios and usage examples.

---

## Setup

### Make the script executable
```bash
chmod +x run.sh
```

### Prerequisites
- Maven installed and configured
- Java Development Kit (JDK) installed
- Docker installed (required for platform-specific and Docker scenarios)
- Chrome and/or Firefox browsers installed (for local scenarios only)

---

## Common Use Cases

### Quick Local Development Test
```bash
./run.sh tdd-chrome
```
Test with Chrome locally during active development.

### Before Committing Code
```bash
./run.sh local-all
```
Run all local tests to ensure no immediate regressions.

### Comprehensive Pre-Commit Testing
```bash
./run.sh docker-all
```
Run containerized tests for consistency across environments.

### Cross-Platform QA Testing
```bash
./run.sh all-platforms
```
Full platform validation on Linux, Windows, and Mac.

### Pre-Release Quality Assurance
```bash
./run.sh all
```
Complete test suite across all browsers and platforms before release.

### CI/CD Pipeline - Linux Build
```bash
./run.sh linux-all
```

### CI/CD Pipeline - Windows Build
```bash
./run.sh windows-all
```

### CI/CD Pipeline - Mac Build
```bash
./run.sh mac-all
```

---

## Test Suites Included

### Regression Test Runners
- **interactionRunner.xml** - Tests for user interactions and widget interactions
- **widgetsModulePtOneRunner.xml** - Tests for widget modules (Part One)

Both test suites are executed in all scenarios to ensure comprehensive coverage.

---

## Troubleshooting

### Docker not available
If using platform-specific or Docker scenarios without Docker installed:
```bash
./run.sh tdd-chrome  # Use local browser instead
```

### Permission denied
If you see "Permission denied" error when running ./run.sh:
```bash
chmod +x run.sh
```

### Maven not found
Ensure Maven is installed and in your system PATH:
```bash
mvn --version
```

### Docker daemon not running
Start Docker daemon before running Docker-based scenarios:
```bash
# On macOS
open /Applications/Docker.app

# On Linux
sudo systemctl start docker

# On Windows
Start-Service docker  # PowerShell
```

### Test failures with Docker
Ensure Docker has sufficient resources allocated:
- Memory: At least 4GB recommended
- Disk space: At least 10GB available

---

## Notes
- All test executions start with `mvn clean` to ensure a fresh state and no cached artifacts
- Test results are typically found in `target/surefire-reports/` directory
- Platform-specific tests (Linux, Windows, Mac) require Docker daemon to be running
- Each test run is independent and can be executed in any order
- For CI/CD pipelines, Docker scenarios are recommended for consistency