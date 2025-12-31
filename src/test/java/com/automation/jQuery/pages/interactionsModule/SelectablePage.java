package com.automation.jQuery.pages.interactionsModule;

import com.automation.jQuery.bases.PageBase;
import org.dom4j.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class SelectablePage extends PageBase {

    Document document = xmlReader.getData("/src/test/resources/locators/locators.xml");

    private By serializeBrn = By.xpath(document.selectSingleNode("//Pages/SelectablePage/serializeBtn").getText());
    private By comfirmMsg = By.id(document.selectSingleNode("//Pages/SelectablePage/feedback").getText());

    @FindBy(xpath = "//ol[@id='selectable']/*")
    private List<WebElement> selectItems;

    public SelectablePage() {
        PageFactory.initElements(driver, this);
    }

    public SelectablePage selectItem(int first, int end) {
        logger.info("User select an item");

        webElem.click(serializeBrn);
        waitUtil.wait(2);
        info("User cliked Serialize Button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        selectUtil.select(selectItems, first, end);
        waitUtil.wait(2);
        info("User selected an item");

        return this;
    }

    public void verifySelectedItem(String expectedMsg) {
        logger.info("Verify the selected Item");

        assertUtil.verifyMsg(comfirmMsg, expectedMsg);
        info("Verified the" + comfirmMsg + " with " + expectedMsg);
    }
}
