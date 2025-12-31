package com.automation.jQuery.tests.regression.effectsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import org.testng.annotations.Test;

public class AddClassEffectSelectionTest extends TestBase {

    @Test(description = "User selects from dropdown menu")
    public void TestCase12() {

        logger = extent.createTest("TestCase12");

        new Homepage().clickAddClassBtn()
                .selectEffectByValue("Clip")
                .isSelectedOptionClicked("Clip");

    }

}
