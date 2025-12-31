package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class RadioButtonClickingUtil {

    private WebDriver driver;

    public RadioButtonClickingUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void radioButtonClicking(WebElement radioBtn) {
        try {
            radioBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while clicking radio button");
        }

    }
}
