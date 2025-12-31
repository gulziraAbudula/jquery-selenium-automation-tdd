package com.automation.jQuery.pages.widgetsModulePtOne;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class CheckBoxRadioPage extends PageBase {

    @FindBy(xpath = "//h2[text()='Checkbox nested in label']")
    private WebElement scrollVisibleIndex;

    @FindBy(xpath = "//label/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']")
    private List<WebElement> listOfOptions;

    public CheckBoxRadioPage() {
        PageFactory.initElements(driver, this);
    }

    public CheckBoxRadioPage clickBoxes(int locationIndex, int ratingIndex, int bedTypeInx1, int bedTypeInx2) {
        logger.info("User clicks specific boxes");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        scrollUtil.scrollByVisibleElement(scrollVisibleIndex);
        waitUtil.wait(1);
        info("User scrolled down the selection section");

        radioUtil.radioButtonClicking(listOfOptions.get(locationIndex));
        waitUtil.wait(1);
        info("User clicked the location of the hotel");

        checkBoxUtil.selectCheckBox(listOfOptions.get(ratingIndex));
        waitUtil.wait(1);
        info("User clicked the rating of the hotel");

        checkBoxUtil.selectCheckBox(listOfOptions.get(bedTypeInx1));
        waitUtil.wait(2);
        checkBoxUtil.selectCheckBox(listOfOptions.get(bedTypeInx2));
        waitUtil.wait(1);
        info("User clicked multiple options for bed type");

        return this;
    }

    public void verifycheckBox(String expectedAttribute,String typeOfAttribute, int indexNum) {
        logger.info("Verifying if radio Button and checkbox is clicked");

        String actualAttribute = listOfOptions.get(indexNum).getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
