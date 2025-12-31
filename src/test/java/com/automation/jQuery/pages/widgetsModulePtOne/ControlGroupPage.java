package com.automation.jQuery.pages.widgetsModulePtOne;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class ControlGroupPage extends PageBase {

    @FindBy(xpath = "(//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s'])[1]")
    private WebElement compactOptionBtn1;

    @FindBy(xpath = "(//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s'])[2]")
    private WebElement compactOptionBtn2;

    @FindBy(xpath = "(//button[@class='ui-widget ui-controlgroup-item ui-button ui-corner-right'])")
    private WebElement bookNowOne;

    @FindBy(id = "book")
    private WebElement bookNowTwo;

    @FindBy(id = "ui-id-8")
    private List<WebElement> compactOptions1;

    @FindBy(xpath = "//li/div[contains(@tabindex, '-1')]")
    private List<WebElement> compactOptions2;

    @FindBy(xpath = "(//span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])")
    private List<WebElement> radioBtnOptions;

    @FindBy(xpath = "(//label[@class = 'ui-button ui-widget ui-checkboxradio-label ui-controlgroup-item'])")
    private List<WebElement> insuranceOptions;

    @FindBy(xpath = "(//span[@class = 'ui-button-icon ui-icon ui-icon-triangle-1-n'])[1]")
    private WebElement upIcon;

    @FindBy(xpath = "(//span[@class = 'ui-button-icon ui-icon ui-icon-triangle-1-s'])")
    private WebElement downIcon;

    public ControlGroupPage() {
        PageFactory.initElements(driver, this);
    }

    public void rentCar(int locationIndex, String inputCommand, int BtnCLickingTimes, String selectItemValue) {
        logger.info("User click set and get button and handle pop up alert");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        compactOptionBtn1.click();
        waitUtil.wait(1);
        selectDropdownUtil.selectByValue(compactOptions1, compactOptionBtn1, selectItemValue);
        waitUtil.wait(2);
        info("User select one of the option by value");

        radioUtil.radioButtonClicking(radioBtnOptions.get(locationIndex));
        waitUtil.wait(1);
        info("User clicks one of the option");

        insuranceOptions.get(1).click();
        waitUtil.wait(2);


        if (inputCommand.equals("up")) {
            spinnerUtil.clickSpinner(BtnCLickingTimes, upIcon);
            waitUtil.wait(1);
            info("User clicks up icon " + BtnCLickingTimes + "times");
        } else if (inputCommand.equals("down")) {
            spinnerUtil.clickSpinner(BtnCLickingTimes, downIcon);
            waitUtil.wait(1);
            info("User clicks down icon " + BtnCLickingTimes + "times");
        } else {
            info("it didn't click anything");
        }

        bookNowOne.click();
        waitUtil.wait(1);
    }
}
