package com.automation.jQuery.pages.widgetsModulePtTwo;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class DialogPage extends PageBase {

    @FindBy(xpath = "(//a[text()='Animation'])")
    private WebElement animationBtn;

    @FindBy(id = "opener")
    private WebElement openDialogBtn;

    @FindBy(id = "dialog")
    private WebElement dialogContent;

    @FindBy(id = "ui-id-1")
    private WebElement basicDialogMsg;

    @FindBy(xpath = "(//span[@class='ui-button-icon ui-icon ui-icon-closethick'])")
    private WebElement closeBtn;

    public DialogPage() {
        PageFactory.initElements(driver, this);
    }

    public DialogPage openDialog() {
        logger.info("User wait till dialog opens");

        animationBtn.click();
        waitUtil.wait(1);
        info("User clicked Animation Button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        openDialogBtn.click();
        waitTillDownloadUtil.waitForFileDownload(3, dialogContent, closeBtn);
        waitUtil.wait(2);
        info("User clicked Start download button and wait till it finish download");

		/*closeBtn.click();
		waitUtil.wait(1);
		info("User clicks close button");*/

        return this;
    }

    public void verifyIfDialogIsOpened(String expectedValue) {
        logger.info("Verifying the sortable Items");

        String actualValue = basicDialogMsg.getText();
        Assert.assertEquals(expectedValue, actualValue);
        info("verify the actual item: " + actualValue + "with expected item: " + expectedValue);
    }
}
