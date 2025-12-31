package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class SelectableMultipleItemsUtil {

    private WebDriver driver;

    public SelectableMultipleItemsUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void select(List<WebElement> selectableItems, int startingIndex, int endingIndex) {
        try {
            Actions toSelect = new Actions(driver);
            toSelect.clickAndHold(selectableItems.get(startingIndex))
                    .clickAndHold(selectableItems.get(endingIndex))
                    .click();

            Action selectItems = toSelect.build();
            selectItems.perform();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            error("error appeared while selecting multiple elements");
        }
    }
}
