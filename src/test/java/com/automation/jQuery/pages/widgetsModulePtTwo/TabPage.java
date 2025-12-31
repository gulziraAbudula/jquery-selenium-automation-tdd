package com.automation.jQuery.pages.widgetsModulePtTwo;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class TabPage extends PageBase {

    @FindBy(xpath = "//a[text()='Aenean lacinia']")
    private WebElement tabBtn;

    public TabPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickTab() {
        logger.info("User click Tab option");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        tabBtn.click();
        waitUtil.wait(2);
    }
}
