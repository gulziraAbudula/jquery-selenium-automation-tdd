package com.automation.jQuery.pages.interactionsModule;

import com.automation.jQuery.bases.PageBase;
import org.dom4j.Document;
import org.openqa.selenium.By;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class DroppablePage extends PageBase {

    Document document = xmlReader.getData("/src/test/resources/locators/locators.xml");

    private By dragItem = By.id(document.selectSingleNode("//Pages/DroppablePage/dragMeToMyTarget").getText());
    private By dropItem = By.id(document.selectSingleNode("//Pages/DroppablePage/dropHere").getText());
    private By successfullyDroppedMsg = By.xpath(document.selectSingleNode("//Pages/DroppablePage/droppedMsg").getText());

    public DroppablePage dragAndDrop() {
        logger.info("User drags the box and drop it in the Drop Here box");
        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("driver switched to iframe driver");
        dNdUtil.dragNdrop(dragItem, dropItem);
        waitUtil.wait(2);
        info("User draged the box to the target box");
        return this;
    }

    public void isBoxSuccessfullyDropped(String expectedMsg) {
        logger.info("Verify the Dropped! message");

        assertUtil.verifyMsg(successfullyDroppedMsg, expectedMsg);
        info("Verified the" + successfullyDroppedMsg + " with " + expectedMsg);
    }
}
