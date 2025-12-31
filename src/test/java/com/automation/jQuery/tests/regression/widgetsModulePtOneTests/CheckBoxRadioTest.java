package com.automation.jQuery.tests.regression.widgetsModulePtOneTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtOne.CheckBoxRadioPage;
import org.testng.annotations.Test;

public class CheckBoxRadioTest extends TestBase {

    @Test(description = "User clicks radio button and selects check box")
    public void TestCase07() {

        logger = extent.createTest("TestCase07");

        new Homepage().clickCheckBoxRadioBtn();
        new CheckBoxRadioPage().clickBoxes(0, 4, 6,7).verifycheckBox(
                "ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank", "class", 1);
        //verify the second radio button is not clicked
    }
}
