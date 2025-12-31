package com.automation.jQuery.pages.utilityModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class PositionPage extends PageBase {

    @FindBy( xpath = "//div[@id = 'positionable1']")
    private WebElement verifyMsg_positionable1;

    @FindBy( id = "my_horizontal")
    private List<WebElement> my_horizontal;

    @FindBy( id = "my_horizontal")
    private WebElement my_horizontalBtn;

    @FindBy(id = "my_vertical")
    private List<WebElement> my_vertical;

    @FindBy( id = "my_vertical")
    private WebElement my_veriticalBtn;

    @FindBy( id = "at_horizontal")
    private List<WebElement> at_horizontal;

    @FindBy( id = "at_horizontal")
    private WebElement at_horizontalBtn;

    @FindBy( id = "at_vertical")
    private List<WebElement> at_vertical;

    @FindBy( id = "at_vertical")
    private WebElement at_verticalBtn;

    @FindBy( id = "collision_horizontal")
    private List<WebElement> collision_horizontal;

    @FindBy( id = "collision_horizontal")
    private WebElement collision_horizontalBtn;

    @FindBy( id = "collision_vertical")
    private List<WebElement> collision_vertical;

    @FindBy( id = "collision_vertical")
    private WebElement collision_verticalBtn;


    public PositionPage() {
        PageFactory.initElements(driver, this);
    }

    public PositionPage selectPositionsByValue(String inputMy1,String inputMy2,String inputAt1,String inputAt2,String inputColl1,String inputColl2) {
        logger.info("User select dropdown by value");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        my_horizontalBtn.click();
        selectDropdownUtil.selectByValue(my_horizontal,my_horizontalBtn, inputMy1);
        waitUtil.wait(2);
        info("User selected my option by value");

        my_veriticalBtn.click();
        selectDropdownUtil.selectByValue(my_vertical,my_veriticalBtn, inputMy2);
        waitUtil.wait(2);
        info("User selected my option by value");

        at_horizontalBtn.click();
        selectDropdownUtil.selectByValue(at_horizontal,at_horizontalBtn, inputAt1);
        waitUtil.wait(2);
        info("User selected at option by value");

        at_verticalBtn.click();
        selectDropdownUtil.selectByValue(at_vertical,at_verticalBtn, inputAt2);
        waitUtil.wait(2);
        info("User selected at option by value");

        collision_horizontalBtn.click();
        selectDropdownUtil.selectByValue(collision_horizontal,collision_horizontalBtn, inputColl1);
        waitUtil.wait(2);
        info("User selected Collision option by value");

        collision_verticalBtn.click();
        selectDropdownUtil.selectByValue(collision_vertical,collision_verticalBtn, inputColl2);
        waitUtil.wait(2);
        info("User selected Collision option by value");

        return this;
    }

    public PositionPage selectPositionByIndex(int inputMy1,int inputMy2,int inputAt1,int inputAt2,int inputColl1,int inputColl2) {
        logger.info("User select menu with value");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        my_horizontalBtn.click();
        selectDropdownUtil.selectByIndex(my_horizontalBtn, inputMy1);
        waitUtil.wait(2);
        info("User selected speed option by index");

        my_veriticalBtn.click();
        selectDropdownUtil.selectByIndex(my_veriticalBtn, inputMy2);
        waitUtil.wait(2);
        info("User selected file option by index");

        at_horizontalBtn.click();
        selectDropdownUtil.selectByIndex(at_horizontalBtn, inputAt1);
        waitUtil.wait(2);
        info("User selected number option by index");

        at_verticalBtn.click();
        selectDropdownUtil.selectByIndex(at_verticalBtn, inputAt2);
        waitUtil.wait(2);
        info("User selected Title option by index");

        collision_horizontalBtn.click();
        selectDropdownUtil.selectByIndex(collision_horizontalBtn, inputColl1);
        waitUtil.wait(2);
        info("User selected Title option by index");

        collision_verticalBtn.click();
        selectDropdownUtil.selectByIndex(collision_verticalBtn, inputColl2);
        waitUtil.wait(2);
        info("User selected Title option by index");
        return this;
    }

    public void verifyDropdownwithPosition1Attribute(String expectedAttribute,String typeOfAttribute) {
        logger.info("Verifying if position is moved");

        String actualAttribute = verifyMsg_positionable1.getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(2);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
