package com.automation.jQuery.tests.regression.interactionsModuleTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.interactionsModule.ResizablePage;
import org.testng.annotations.Test;

public class ResizeSelectItemTest extends TestBase {

    @Test(description = "Resize selected item")
    public void TestCase02() {

        logger = extent.createTest("TestCase02");

        new Homepage().clickResizeBtn();
        new ResizablePage().resize(100,100).verifyResizableItem("width: 250px; height: 250px;", "style");
    }
}
