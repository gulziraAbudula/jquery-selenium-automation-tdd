package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.TabPage;
import org.testng.annotations.Test;

public class TabTest extends TestBase {

    @Test(description = "User clicks one of the tabs")
    public void TestCase19() {

        logger = extent.createTest("TestCase19");

        new Homepage().clickTabBtn();
        new TabPage().clickTab();
    }
}
