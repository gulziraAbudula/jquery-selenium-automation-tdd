package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class DragAndDropUtil {

    private WebDriver driver;

    public DragAndDropUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void dragNdrop(By from, By to) {
        try {
            WebElement first = driver.findElement(from);
            WebElement second = driver.findElement(to);
            Actions builder = new Actions(driver);

            Action dragAndDrop = builder.clickAndHold(first)
                    .moveToElement(second)
                    .release(second).build();

            dragAndDrop.perform();
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while draging the box: " + from + "to target destination: " + to);
        }
    }
}
