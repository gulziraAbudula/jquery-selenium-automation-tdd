package com.automation.jQuery.tests.regression.widgetsModulePtOneTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import org.testng.annotations.Test;

public class ControlGroupTest extends TestBase {

    @Test(description = "User change color to green and click toggle option")
    public void TestCase18() {

        logger = extent.createTest("TestCase18");

        new Homepage().clickControlGroupBtn().rentCar(2, "up", 3, "Full size car");

    }
}
