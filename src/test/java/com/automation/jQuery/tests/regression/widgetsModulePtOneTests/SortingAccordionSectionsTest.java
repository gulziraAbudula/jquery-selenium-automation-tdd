package com.automation.jQuery.tests.regression.widgetsModulePtOneTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtOne.AccordionPage;
import org.testng.annotations.Test;

public class SortingAccordionSectionsTest extends TestBase {

    @Test(description = "Click on accordion section and sort it to specific area")
    public void TestCase05() {

        logger = extent.createTest("TestCase05");

        new Homepage().clickAccordBtn();
        new AccordionPage().accordSections(0, 1).verifySortableItems("Section 2", 1);
    }
}
