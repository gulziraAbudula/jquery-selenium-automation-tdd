package com.automation.jQuery.pages.utilityModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class WidgetsFactoryPage extends PageBase {

    @FindBy(id = "green")
    private WebElement goGreenBtn;

    @FindBy(id = "disable")
    private WebElement toggleDisplayOpt;

    @FindBy(xpath = "//button[@class = 'custom-colorize-changer ui-button ui-corner-all ui-widget']")
    private WebElement chengeBtn;

    @FindBy(xpath = "//div[@id = 'my-widget1']")
    private WebElement verifyImage;

    public WidgetsFactoryPage() {
        PageFactory.initElements(driver, this);
    }

    public WidgetsFactoryPage changeColor() {
        logger.info("User clicks Green option to make the display color change");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        goGreenBtn.click();
        waitUtil.wait(1);
        info("User clicked Go Green button");

        toggleDisplayOpt.click();
        waitUtil.wait(1);
        info("User clicked Toggle Display Option button");

        return this;
    }

    public void verifyAnimationItem(String expectedAttribute,String typeOfAttribute) {
        logger.info("Verifying if the image changed in color with attribute");

        String actualAttribute =verifyImage.getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
