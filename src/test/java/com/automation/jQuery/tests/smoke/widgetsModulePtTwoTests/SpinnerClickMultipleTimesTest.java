package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.SpinnerPage;
import org.testng.annotations.Test;

public class SpinnerClickMultipleTimesTest extends TestBase {

    @Test(description = "User clicks spinner button multiple times")
    public void TestCase11() {

        logger = extent.createTest("TestCase11");

        new Homepage().clickSpinnerBtn();
        new SpinnerPage().clickUPOrDownIcon("up", 5).verifyInputValue("value", "name");;
    }
}
