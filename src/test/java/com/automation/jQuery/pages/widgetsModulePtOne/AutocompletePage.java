package com.automation.jQuery.pages.widgetsModulePtOne;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class AutocompletePage extends PageBase {

    @FindBy(css = ".ui-menu-item/*")
    private List<WebElement> autoOptions;

    @FindBy(id = "tags")
    private WebElement tagsInputBox;

    @FindBy(xpath = "//li/div[contains(@id,'ui')]") //xpath with by using 'contains' to find list of elements
    private List<WebElement> verifyAutoDisplayMsg;

    public AutocompletePage() {
        PageFactory.initElements(driver, this);
    }

    public AutocompletePage autocomplete(String inputValue, int autoOptionIndex) {
        logger.info("User auto complete the box");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        tagsInputBox.click();
        autoUtil.autoComplete(autoOptions, tagsInputBox, inputValue, autoOptionIndex);
        waitUtil.wait(2);
        info("User clicked auto displayed option");

        return this;
    }

    public void verifyAutoItem(String expectedAttribute,String typeOfAttribute, int indexNum) {
        logger.info("Verifying if auto option was click");

        String actualAttribute = verifyAutoDisplayMsg.get(indexNum).getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
