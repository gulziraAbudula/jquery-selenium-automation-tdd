package com.automation.jQuery.pages.widgetsModulePtOne;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class ProgressBar_DownloadDialogPage extends PageBase {

    @FindBy(xpath = "//a[text()='Download Dialog']")
    private WebElement downloadDialogBtn;

    @FindBy(id = "downloadButton")
    private WebElement downloadBtn;

    @FindBy(xpath = "(//button[text()='Close'])[2]")
    private WebElement closeBtn;

    @FindBy(xpath = "(//div[text()='Complete!'])")
    private WebElement completeDownloadMsg;

    public ProgressBar_DownloadDialogPage() {
        PageFactory.initElements(driver, this);
    }

    public ProgressBar_DownloadDialogPage downloadFile() {
        logger.info("User wait till file downloads");

        downloadDialogBtn.click();
        waitUtil.wait(1);
        info("User clicked Download Dialog Button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        downloadBtn.click();
        waitTillDownloadUtil.waitForFileDownload(3, completeDownloadMsg, closeBtn);
        waitUtil.wait(2);
        info("User clicked Start download button and wait till it finish download");

        return this;
    }

    public void verifyIfFileDownload(String expectedValue) {
        logger.info("Verifying the sortable Items");

        String actualValue = completeDownloadMsg.getText();
        Assert.assertEquals(expectedValue, actualValue);
        info("verify the actual item: " + actualValue + "with expected item: " + expectedValue);
    }
}
