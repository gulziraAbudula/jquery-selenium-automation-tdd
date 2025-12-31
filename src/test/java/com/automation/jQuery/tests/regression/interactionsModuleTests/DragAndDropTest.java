package com.automation.jQuery.tests.regression.interactionsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.interactionsModule.DroppablePage;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {

    @Test(description = "Drag the box to the target destination")
    public void TestCase01() {

        logger = extent.createTest("TestCase01");

        new Homepage().clickDropBtn();
        new DroppablePage().dragAndDrop().isBoxSuccessfullyDropped("Dropped!");
    }
}
