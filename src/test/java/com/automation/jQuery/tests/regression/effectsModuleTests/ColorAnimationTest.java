package com.automation.jQuery.tests.regression.effectsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.effectsModule.ColorAnimationPage;
import org.testng.annotations.Test;

public class ColorAnimationTest extends TestBase{

    @Test(description = "User selects from dropdown menu")
    public void TestCase13() {

        logger = extent.createTest("TestCase13");

        new Homepage().clickColorAnimationBtn();
        new ColorAnimationPage().clickToggleEffect()
                .verifyAnimationItem("background-color: rgb(170, 0, 0); color: rgb(255, 255, 255); width: 500px;", "style");

    }
}
