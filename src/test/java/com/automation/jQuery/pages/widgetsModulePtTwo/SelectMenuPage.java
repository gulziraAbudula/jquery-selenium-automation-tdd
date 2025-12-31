package com.automation.jQuery.pages.widgetsModulePtTwo;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class SelectMenuPage extends PageBase {

    @FindBy(id = "speed")
    private WebElement speedOption;

    @FindBy(id = "files")
    private WebElement fileOption;

    @FindBy(id = "number")
    private WebElement numberOption;

    @FindBy(id = "salutation")
    private WebElement titleOption;

    @FindBy(id = "speed-button")
    private WebElement speedBtn;

    @FindBy(id = "files-button")
    private WebElement fileBtn;

    @FindBy(id = "number-button")
    private WebElement numberBtn;

    @FindBy(id = "salutation-button")
    private WebElement titleBtn;

    @FindBy(css = "[role ='option']")
    List<WebElement> options;

    public SelectMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public SelectMenuPage selectMenuByValue(String inputSpeed,String inputFile,String inputNumber,String inputTitle) {
        logger.info("User select menu with value");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        speedBtn.click();
        selectDropdownUtil.selectByValue(options,speedOption, inputSpeed);
        waitUtil.wait(2);
        info("User selected speed option by value");

        fileBtn.click();
        selectDropdownUtil.selectByValue(options,fileOption, inputFile);
        waitUtil.wait(2);
        info("User selected file option by value");

        numberBtn.click();
        selectDropdownUtil.selectByValue(options,numberOption, inputNumber);
        waitUtil.wait(2);
        info("User selected number option by value");

        titleBtn.click();
        selectDropdownUtil.selectByValue(options,titleOption, inputTitle);
        waitUtil.wait(2);
        info("User selected Title option by value");

        return this;
    }

    public SelectMenuPage selectMenuByVisibleText(String inputSpeed,String inputFile,String inputNumber,String inputTitle) {
        logger.info("User select menu with visible text");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        speedBtn.click();
        selectDropdownUtil.selectByVisibleText(options, speedOption, inputSpeed);
        waitUtil.wait(2);
        info("User selected speed option by visible text");

        fileBtn.click();
        selectDropdownUtil.selectByVisibleText(options, fileOption, inputFile);
        waitUtil.wait(2);
        info("User selected file option by visible text");

        numberBtn.click();
        selectDropdownUtil.selectByVisibleText(options, numberOption, inputNumber);
        waitUtil.wait(2);
        info("User selected number option by visible text");

        titleBtn.click();
        selectDropdownUtil.selectByVisibleText(options, titleOption, inputTitle);
        waitUtil.wait(2);
        info("User selected Title option by visible text");

        return this;
    }

    public SelectMenuPage selectMenuByIndex(int inputSpeed,int inputFile,int inputNumber,int inputTitle) {
        logger.info("User select menu with value");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        selectDropdownUtil.selectByIndex(speedOption, inputSpeed);
        waitUtil.wait(2);
        info("User selected speed option by index");

        selectDropdownUtil.selectByIndex(fileOption, inputFile);
        waitUtil.wait(2);
        info("User selected file option by index");

        selectDropdownUtil.selectByIndex(numberOption, inputNumber);
        waitUtil.wait(2);
        info("User selected number option by index");

        selectDropdownUtil.selectByIndex(titleOption, inputTitle);
        waitUtil.wait(2);
        info("User selected Title option by index");

        return this;
    }

    public void verifyDropdownwithSpeedAttribute(String expectedAttribute,String typeOfAttribute) {
        logger.info("Verifying if auto option was click");

        String actualAttribute = speedBtn.getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
