package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;
import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class WaitUtil {

    private WebDriver driver;

    public WaitUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void wait(int i) {
        try {
            Thread.sleep(i*1000);
            info("waited for " + i + " seconds");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            error("error caught while waiting");
        }
    }
}
