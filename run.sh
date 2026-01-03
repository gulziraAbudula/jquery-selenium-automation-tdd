#!/bin/bash

# jQuery TDD Test Execution Script
# Runs Maven test configurations based on specified scenarios

set -e  # Exit on error

# Color output for better readability
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Print help message
print_help() {
    cat << EOF
${BLUE}jQuery TDD Test Runner${NC}

${GREEN}Usage:${NC}
  ./run.sh <scenario> [options]

${GREEN}Local Browser Tests:${NC}
  tdd-firefox              Run TDD tests with Firefox browser (local)
  tdd-chrome               Run TDD tests with Chrome browser (local)

${GREEN}Docker Container Tests:${NC}
  tdd-chrome-docker        Run TDD tests with Chrome in Docker
  tdd-firefox-docker       Run TDD tests with Firefox in Docker

${GREEN}Linux Platform Tests:${NC}
  linux-chrome             Run tests on Linux with Chrome
  linux-firefox            Run tests on Linux with Firefox

${GREEN}Windows Platform Tests:${NC}
  windows-chrome           Run tests on Windows with Chrome
  windows-firefox          Run tests on Windows with Firefox

${GREEN}Mac Platform Tests:${NC}
  mac-chrome               Run tests on Mac with Chrome
  mac-firefox              Run tests on Mac with Firefox

${GREEN}Batch Operations:${NC}
  local-all                Run all local browser tests
  docker-all               Run all Docker container tests
  linux-all                Run all Linux platform tests
  windows-all              Run all Windows platform tests
  mac-all                  Run all Mac platform tests
  all-platforms            Run tests on all platforms (Linux, Windows, Mac)
  all                      Run all test configurations
  help                     Display this help message

${YELLOW}Examples:${NC}
  ./run.sh tdd-firefox
  ./run.sh linux-chrome
  ./run.sh all-platforms
  ./run.sh help

EOF
}

# Local Browser Tests
run_tdd_firefox() {
    echo -e "${BLUE}Running TDD tests with Firefox (local)...${NC}"
    mvn clean test \
        -Dbrowser=firefox \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

run_tdd_chrome() {
    echo -e "${BLUE}Running TDD tests with Chrome (local)...${NC}"
    mvn clean test \
        -Dbrowser=chrome \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

# Docker Container Tests
run_tdd_chrome_docker() {
    echo -e "${BLUE}Running TDD tests with Chrome in Docker...${NC}"
    mvn clean test \
        -Dbrowser=chrome \
        -Dexecution.mode=docker \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

run_tdd_firefox_docker() {
    echo -e "${BLUE}Running TDD tests with Firefox in Docker...${NC}"
    mvn clean test \
        -Dbrowser=firefox \
        -Dexecution.mode=docker \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

# Linux Platform Tests
run_linux_chrome() {
    echo -e "${BLUE}Running tests on Linux with Chrome...${NC}"
    mvn clean test \
        -Dbrowser=chrome \
        -Dexecution.mode=docker \
        -Dplatform=linux \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

run_linux_firefox() {
    echo -e "${BLUE}Running tests on Linux with Firefox...${NC}"
    mvn clean test \
        -Dbrowser=firefox \
        -Dexecution.mode=docker \
        -Dplatform=linux \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

# Windows Platform Tests
run_windows_chrome() {
    echo -e "${BLUE}Running tests on Windows with Chrome...${NC}"
    mvn clean test \
        -Dbrowser=chrome \
        -Dexecution.mode=docker \
        -Dplatform=windows \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

run_windows_firefox() {
    echo -e "${BLUE}Running tests on Windows with Firefox...${NC}"
    mvn clean test \
        -Dbrowser=firefox \
        -Dexecution.mode=docker \
        -Dplatform=windows \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

# Mac Platform Tests
run_mac_chrome() {
    echo -e "${BLUE}Running tests on Mac with Chrome...${NC}"
    mvn clean test \
        -Dbrowser=chrome \
        -Dexecution.mode=docker \
        -Dplatform=mac \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

run_mac_firefox() {
    echo -e "${BLUE}Running tests on Mac with Firefox...${NC}"
    mvn clean test \
        -Dbrowser=firefox \
        -Dexecution.mode=docker \
        -Dplatform=mac \
        -Dsurefire.suiteXmlFiles=runner/regression/interactionRunner.xml,runner/regression/widgetsModulePtOneRunner.xml
}

# Batch Operations
run_local_all() {
    echo -e "${YELLOW}Running all local browser tests...${NC}\n"
    run_tdd_firefox && echo -e "${GREEN}✓ TDD Firefox (local) completed${NC}\n"
    run_tdd_chrome && echo -e "${GREEN}✓ TDD Chrome (local) completed${NC}\n"
}

run_docker_all() {
    echo -e "${YELLOW}Running all Docker container tests...${NC}\n"
    run_tdd_chrome_docker && echo -e "${GREEN}✓ TDD Chrome Docker completed${NC}\n"
    run_tdd_firefox_docker && echo -e "${GREEN}✓ TDD Firefox Docker completed${NC}\n"
}

run_linux_all() {
    echo -e "${YELLOW}Running all Linux platform tests...${NC}\n"
    run_linux_chrome && echo -e "${GREEN}✓ Linux Chrome completed${NC}\n"
    run_linux_firefox && echo -e "${GREEN}✓ Linux Firefox completed${NC}\n"
}

run_windows_all() {
    echo -e "${YELLOW}Running all Windows platform tests...${NC}\n"
    run_windows_chrome && echo -e "${GREEN}✓ Windows Chrome completed${NC}\n"
    run_windows_firefox && echo -e "${GREEN}✓ Windows Firefox completed${NC}\n"
}

run_mac_all() {
    echo -e "${YELLOW}Running all Mac platform tests...${NC}\n"
    run_mac_chrome && echo -e "${GREEN}✓ Mac Chrome completed${NC}\n"
    run_mac_firefox && echo -e "${GREEN}✓ Mac Firefox completed${NC}\n"
}

run_all_platforms() {
    echo -e "${YELLOW}Running all platform-specific tests...${NC}\n"
    run_linux_all
    run_windows_all
    run_mac_all
}

run_all() {
    echo -e "${YELLOW}Running all TDD test configurations...${NC}\n"
    run_local_all
    run_docker_all
    run_all_platforms
    echo -e "${GREEN}✓ All tests completed${NC}"
}

# Main script logic
if [ $# -eq 0 ]; then
    echo -e "${RED}Error: No scenario specified${NC}"
    print_help
    exit 1
fi

case "$1" in
    # Local browser scenarios
    tdd-firefox)
        run_tdd_firefox
        ;;
    tdd-chrome)
        run_tdd_chrome
        ;;
    # Docker scenarios
    tdd-chrome-docker)
        run_tdd_chrome_docker
        ;;
    tdd-firefox-docker)
        run_tdd_firefox_docker
        ;;
    # Linux scenarios
    linux-chrome)
        run_linux_chrome
        ;;
    linux-firefox)
        run_linux_firefox
        ;;
    # Windows scenarios
    windows-chrome)
        run_windows_chrome
        ;;
    windows-firefox)
        run_windows_firefox
        ;;
    # Mac scenarios
    mac-chrome)
        run_mac_chrome
        ;;
    mac-firefox)
        run_mac_firefox
        ;;
    # Batch operations
    local-all)
        run_local_all
        ;;
    docker-all)
        run_docker_all
        ;;
    linux-all)
        run_linux_all
        ;;
    windows-all)
        run_windows_all
        ;;
    mac-all)
        run_mac_all
        ;;
    all-platforms)
        run_all_platforms
        ;;
    all)
        run_all
        ;;
    help)
        print_help
        ;;
    *)
        echo -e "${RED}Error: Unknown scenario '$1'${NC}"
        print_help
        exit 1
        ;;
esac

echo -e "${GREEN}✓ Test execution completed${NC}"