package com.automation.jQuery.utility.webActionRelated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;

public class SelectDropDownUtil {

    private WebDriver driver;

    public SelectDropDownUtil(WebDriver inputDriver) {
        this.driver = inputDriver;
    }

    public void selectByValue(List<WebElement> options,WebElement inputOption,String selectItemValue) {
        try {
			/*Select select = new Select(inputOption);
			select.selectByValue(selectItemValue);*/
            for (WebElement option : options) {
                if(selectItemValue.equals(option.getText()))
                    option.click();
            }
        }catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while selecting dropdown option with value " + selectItemValue);
        }
    }

    public void selectByIndex( WebElement inputOptions, int selectItemIndex) {
        try {
            Select select = new Select(inputOptions);
            select.selectByIndex(selectItemIndex);
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while selecting dropdown option with index " + selectItemIndex);
        }
    }

    public void selectByVisibleText(List<WebElement> options, WebElement inputOption, String selectItemVisibleText) {
        try {
			/*Select select = new Select(inputOption);
			select.selectByVisibleText(selectItemVisibleText);*/

            for (WebElement option : options) {
                if(selectItemVisibleText.equals(option.getText()))
                    option.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            error("Error appeared while selecting dropdown option with visible index " + selectItemVisibleText);
        }
    }
}
