package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.SelectMenuPage;
import org.testng.annotations.Test;

public class MenuDropdownTest extends TestBase {

    @Test(description = "User selects from dropdown menu")
    public void TestCase09() {

        logger = extent.createTest("TestCase09");

        new Homepage().clickSelectMenuBtn();
        new SelectMenuPage().selectMenuByValue("Slow", "jQuery.js", "4", "Mr.")
                .verifyDropdownwithSpeedAttribute("ui-id-2", "aria-labelledby");
    }
}
