package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class ClickSpinnerUtil {

    private WebDriver driver;

    public ClickSpinnerUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSpinner(int inputNumTimes, WebElement upOrDownButton) {

        try {
            for (int i = 0; i < inputNumTimes; i++) {
                upOrDownButton.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            error("error appeared while clicking spinning button");
        }
    }
}
