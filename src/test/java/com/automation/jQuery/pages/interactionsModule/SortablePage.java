package com.automation.jQuery.pages.interactionsModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class SortablePage extends PageBase {

    @FindBy(css = ".ui-sortable-handle/*")
    private List<WebElement> sortableItems;

    public SortablePage() {
        PageFactory.initElements(driver, this);
    }

    public SortablePage selectItem(int startingElemIndex, int endElemIndex) {
        logger.info("User sorts the lists of items");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        sortUtil.sort(sortableItems, startingElemIndex, endElemIndex);
        waitUtil.wait(5);
        info("User sort the list of item");
        return this;
    }

    public void verifySortableItems(String expected, int expectedItemIndex) {
        logger.info("Verifying the sortable Items");

        String actual = sortableItems.get(expectedItemIndex).getText();
        Assert.assertEquals(actual, expected);
        info("verify the actual item: " + actual + "with expected item: " + expected);

    }
}
