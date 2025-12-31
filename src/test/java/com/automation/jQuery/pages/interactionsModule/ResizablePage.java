package com.automation.jQuery.pages.interactionsModule;

import com.automation.jQuery.bases.PageBase;
import org.dom4j.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class ResizablePage extends PageBase {

    Document document = xmlReader.getData("/src/test/resources/locators/locators.xml");

    private By resizeItem = By.id(document.selectSingleNode("//Pages/ResizablePage/resizeElem").getText());
    private By cornerBtn = By.xpath(document.selectSingleNode("//Pages/ResizablePage/rightBottomCorner").getText());


    public ResizablePage resize(int x, int y) {
        logger.info("User be able to resize the sellected item");
        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("driver switched to iframe driver");
        resizeUtil.resize(cornerBtn,x, y);
        waitUtil.wait(1);
        info("User resized the selected box");
        return this;
    }

    public void verifyResizableItem(String expectedAttribute,String typeOfAttribute) {
        logger.info("Verifying the resizable Items");

        WebElement resizeElem = driver.findElement(resizeItem);
        String actualAttribute = resizeElem.getAttribute(typeOfAttribute);
        Assert.assertEquals(actualAttribute, expectedAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
