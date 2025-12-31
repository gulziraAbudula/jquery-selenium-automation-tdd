package com.automation.jQuery.tests.regression.interactionsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.interactionsModule.SortablePage;
import org.testng.annotations.Test;

public class SortItemsTest extends TestBase {

    @Test(description = "Sort items from sortable options")
    public void TestCase04() {

        logger = extent.createTest("TestCase04");

        new Homepage().clickSortBtn();
        new SortablePage().selectItem(1, 5).verifySortableItems("Item 1", 0);;
    }

}
