package com.automation.jQuery.tests.regression.interactionsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.interactionsModule.SelectablePage;
import org.testng.annotations.Test;

public class SelectItemTest extends TestBase {

    @Test(description = "Select an item from selection options")
    public void TestCase03() {

        logger = extent.createTest("TestCase03");

        new Homepage().clickSelectBtn();
        new SelectablePage().selectItem(1,3).verifySelectedItem("#2 #3 #4");
    }
}
