package com.automation.jQuery.pages.effectsModule;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class AddClassPage extends PageBase {

    @FindBy(id = "button")
    private WebElement runEffectBtn;

    @FindBy(id = "effectTypes")
    private WebElement effectTypesBtn;

    @FindBy( xpath = "//a[text()='Effect demo']")
    private WebElement effectDemoBtn;

    @FindBy(xpath = "//select[@id = 'effectTypes']")
    List<WebElement> effectTypes;

    public AddClassPage() {
        PageFactory.initElements(driver, this);
    }

    public AddClassPage selectEffectByValue(String inputEffectType) {
        logger.info("User select effects for class");

        effectDemoBtn.click();
        waitUtil.wait(1);
        info("User clicked Effect Demo button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        effectTypesBtn.click();
        selectDropdownUtil.selectByValue(effectTypes, effectTypesBtn, inputEffectType);
        waitUtil.wait(5);
        info("User select one of the effect from dropdown options");

        runEffectBtn.click();
        waitUtil.wait(1);
        info("User click Run Effect Button");

        return this;
    }

    public boolean isSelectedOptionClicked(String expectedValue) {
        logger.info("Verifying if one of the effect is clicked");

        String ActualEffectName = effectTypesBtn.getText();
        System.out.println("the title name is: " + ActualEffectName);
        return ActualEffectName.equalsIgnoreCase(expectedValue);
    }
}
