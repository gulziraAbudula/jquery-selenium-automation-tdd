package com.automation.jQuery.pages.widgetsModulePtTwo;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class SpinnerPage extends PageBase {

    @FindBy(id = "setvalue")
    private WebElement setValueBtn;

    @FindBy(id = "getvalue")
    private WebElement getValueBtn;

    @FindBy(id = "spinner")
    private WebElement spinner;

    @FindBy(xpath = "//span[@class='ui-button-icon ui-icon ui-icon-triangle-1-n']")
    private WebElement upIcon;

    @FindBy(xpath = "//span[@class='ui-button-icon-space']")
    private WebElement downIcon;

    @FindBy(xpath = "//button[@id='destroy']")
    private WebElement toggleWedgetsBtn;

    @FindBy (xpath = "//input[@id='spinner']")
    private WebElement inputBox;

    public SpinnerPage() {
        PageFactory.initElements(driver, this);
    }

    public SpinnerPage alertHandle() {
        logger.info("User click set and get button and handle pop up alert");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        setValueBtn.click();
        waitUtil.wait(1);
        getValueBtn.click();
        waitUtil.wait(1);
        info("User set the value to 5 and get the value");

        alertUtil.AcceptAlert();
        waitUtil.wait(1);
        info("User accept the alert");

        return this;
    }

    public SpinnerPage clickUPOrDownIcon(String inputCommand, int BtnCLickingTimes) {
        logger.info("User click either up ican or down icon and click Toggle Widgets button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        if (inputCommand.equals("up")) {
            spinnerUtil.clickSpinner(BtnCLickingTimes, upIcon);
            waitUtil.wait(1);
            info("User clicks up icon " + BtnCLickingTimes + "times");
        } else if (inputCommand.equals("down")) {
            spinnerUtil.clickSpinner(BtnCLickingTimes, downIcon);
            waitUtil.wait(1);
            info("User clicks down icon " + BtnCLickingTimes + "times");
        } else {
            info("it didn't click anything");
        }

        toggleWedgetsBtn.click();
        waitUtil.wait(2);
        info("User clicks on Toggle Wedgets button");

        return this;

    }

    public void verifyInputValue(String expectedAttribute, String typeOfAttribute) {
        logger.info("Verifying if input value is expected");

        String actualAttribute = spinner.getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }

    public void VerifyInputValue(String expectedValue) {
        logger.info("Verifying the spinner value");

        String actualValue = inputBox.getText();
        Assert.assertEquals(actualValue, expectedValue);
        info("verify the actual item: " + actualValue + "with expected item: " + expectedValue);
    }
}
