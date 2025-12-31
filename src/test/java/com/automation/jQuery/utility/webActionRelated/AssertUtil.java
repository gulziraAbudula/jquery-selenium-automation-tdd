package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class AssertUtil {

    private WebDriver driver;

    public AssertUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void verifyMsg(By by, String expectedValue) {
        try {
            WebElement elem = driver.findElement(by);
            String actualMsg = elem.getText();
            Assert.assertEquals(actualMsg, expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
            error("While asserting the actual and expected value, error appeared in" + by + expectedValue);
        }
    }
}
