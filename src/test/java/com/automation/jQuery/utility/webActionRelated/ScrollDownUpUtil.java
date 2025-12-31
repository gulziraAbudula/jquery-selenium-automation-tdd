package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class ScrollDownUpUtil {

    private WebDriver driver;

    public ScrollDownUpUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void scrollWindow(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy" + "(" + x + "," + y + ")");
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while scrolling the window");
        }

    }

    public void scrollByVisibleElement(WebElement visibleElem) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", visibleElem );
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while scrolling the window");
        }

    }
}
