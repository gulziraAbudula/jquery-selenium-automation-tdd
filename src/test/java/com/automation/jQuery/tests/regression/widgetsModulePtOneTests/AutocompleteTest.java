package com.automation.jQuery.tests.regression.widgetsModulePtOneTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtOne.AutocompletePage;
import org.testng.annotations.Test;

public class AutocompleteTest extends TestBase {

    @Test(description = "User clicks auto options")
    public void TestCase06() {

        logger = extent.createTest("TestCase06");

        new Homepage().clickAutocompleteBtn();
        new AutocompletePage().autocomplete("ja", 0).verifyAutoItem("ui-id-2", "id", 0);
    }

}
