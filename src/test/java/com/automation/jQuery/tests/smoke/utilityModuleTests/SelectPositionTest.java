package com.automation.jQuery.tests.smoke.utilityModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import org.testng.annotations.Test;

public class SelectPositionTest extends TestBase {

    @Test(description = "Select values from selections")
    public void TestCase16() {

        logger = extent.createTest("TestCase16");

		/*new Homepage().clickPositionBtn()
						.selectPositionsByValue("center", "center", "center", "center", "fit", "fit")
						.verifyDropdownwithPosition1Attribute("opacity: 0.5; top: 0px; left: 255.806px;", "style");*/

        new Homepage().clickPositionBtn()
                .selectPositionByIndex(1, 1, 1, 1, 1, 1)
                .verifyDropdownwithPosition1Attribute("opacity: 0.5; top: 0px; left: 255.749px;", "style");
    }
}
