package com.automation.jQuery.pages.effectsModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class ColorAnimationPage extends PageBase {

    @FindBy( id = "button")
    private WebElement toggleEffectBtn;

    @FindBy( id = "effect")
    private WebElement animatedImage;

    public ColorAnimationPage() {
        PageFactory.initElements(driver, this);
    }

    public ColorAnimationPage clickToggleEffect() {
        logger.info("User clicks Toggle Effects to make the display color change");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        toggleEffectBtn.click();
        waitUtil.wait(1);
        info("User clicked Toggle Effect Button");

        return this;
    }

    public void verifyAnimationItem(String expectedAttribute,String typeOfAttribute) {
        logger.info("Verifying if the image changed in color with attribute");

        String actualAttribute =animatedImage.getAttribute(typeOfAttribute);
        System.out.println(actualAttribute);
        waitUtil.wait(3);
        Assert.assertEquals(expectedAttribute, actualAttribute);

        info("verifying actual attribute: " + actualAttribute + " with expected attribute: " + expectedAttribute);
    }
}
