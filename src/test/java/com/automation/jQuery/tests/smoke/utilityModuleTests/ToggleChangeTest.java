package com.automation.jQuery.tests.smoke.utilityModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import org.testng.annotations.Test;

public class ToggleChangeTest extends TestBase {

    @Test(description = "User change color to green and click toggle option")
    public void TestCase17() {

        logger = extent.createTest("TestCase17");

        new Homepage().clickWidgetsFactoryBtn()
                .changeColor()
                .verifyAnimationItem("background-color: rgb(64, 250, 8);", "style");

    }
}
