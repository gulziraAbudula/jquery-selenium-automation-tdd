package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.DialogPage;
import org.testng.annotations.Test;

public class DialogDisplayTest extends TestBase {

    @Test(description = "User wait till dialog opens")
    public void TestCase15() {

        logger = extent.createTest("TestCase15");

        new Homepage().clickDialogBtn();
        new DialogPage().openDialog().verifyIfDialogIsOpened("Basic dialog");

    }
}
