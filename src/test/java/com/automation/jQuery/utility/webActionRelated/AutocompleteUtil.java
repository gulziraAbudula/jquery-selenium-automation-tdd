package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class AutocompleteUtil {

    private WebDriver driver;

    public AutocompleteUtil(WebDriver inputDriver) {

        this.driver = inputDriver;
    }

    public void autoComplete(List<WebElement> listOfInputItems, WebElement inputBox, String inputValue, int pickedItemIndex) {
        try {
            inputBox.sendKeys(inputValue);
            listOfInputItems.get(pickedItemIndex).click();
        } catch (Exception e) {
            e.printStackTrace();
            error("error appeared while clicking the auto complete options");
        }

    }
}
