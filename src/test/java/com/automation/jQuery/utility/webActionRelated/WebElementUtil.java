package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class WebElementUtil {

    private WebDriver driver;

    public WebElementUtil(WebDriver InputDriver) {
        this.driver = InputDriver;

    }

    public WebElement elemAsWebElem(By by) {

        WebElement elem = driver.findElement(by);
        return elem;

    }
    public void click(By by){

        try {
            WebElement elem = driver.findElement(by);
            elem.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            error("error appeared when we are clicking the element while locating the element with " + by);
        }

    }

    public void type(By by, String targetText){
        try {
            WebElement elem = driver.findElement(by);
            elem.clear();
            elem.sendKeys(targetText);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            error("error appeared while inputing" + targetText + "while locating with" + by);
        }
    }
}
