package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.SpinnerPage;
import org.testng.annotations.Test;

public class SpinnerAlertHandleTest extends TestBase {

    @Test(description = "User handle alert on spinner page")
    public void TestCase10() {

        logger = extent.createTest("TestCase10");

        new Homepage().clickSpinnerBtn();
        new SpinnerPage().alertHandle().verifyInputValue("5", "aria-valuenow");
    }
}
