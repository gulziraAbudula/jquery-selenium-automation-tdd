package com.automation.jQuery.tests.regression.widgetsModulePtOneTests;

import com.automation.jQuery.bases.TestBase;
import com.automation.jQuery.pages.Homepage;
import com.automation.jQuery.pages.widgetsModulePtOne.ProgressBar_DownloadDialogPage;
import org.testng.annotations.Test;

public class DownloadFileTest extends TestBase {

    @Test(description = "User wait till it finish download")
    public void TestCase14() {

        logger = extent.createTest("TestCase14");

        new Homepage().clickProcessorBarBtn();
        new ProgressBar_DownloadDialogPage().downloadFile().verifyIfFileDownload("Complete!");

    }
}
