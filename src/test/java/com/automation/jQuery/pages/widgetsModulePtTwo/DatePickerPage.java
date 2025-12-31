package com.automation.jQuery.pages.widgetsModulePtTwo;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class DatePickerPage extends PageBase {

    @FindBy(id = "datepicker")
    private WebElement dateInputBox;

    @FindBy(xpath = "//li/div//td/a[contains(@class,'ui')]")
    private List<WebElement> listOfDate;

    public DatePickerPage() {
        PageFactory.initElements(driver, this);
    }

    public DatePickerPage pickADate(String inputValue) {
        logger.info("User pick a date from calendar");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        dateInputBox.click();
        waitUtil.wait(1);
        if (inputValue.equalsIgnoreCase("today")) {
            dateUtil.datePick(listOfDate, dateUtil.getCurrentDay());
            waitUtil.wait(2);
        } else {
            dateUtil.datePick(listOfDate, inputValue);
            waitUtil.wait(2);
        }
        info("User picked a date from calendar");

        return this;
    }

}
