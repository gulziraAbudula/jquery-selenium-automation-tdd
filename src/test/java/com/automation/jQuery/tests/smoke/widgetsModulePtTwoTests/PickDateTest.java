package com.automation.jQuery.tests.smoke.widgetsModulePtTwoTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtTwo.DatePickerPage;
import org.testng.annotations.Test;

public class PickDateTest extends TestBase {

    @Test(description = "User picks a date from the calendar")
    public void TestCase08() {

        logger = extent.createTest("TestCase08");

        new Homepage().clickDatepickerBtn();
        new DatePickerPage().pickADate("today");
    }

}
