package com.automation.jQuery.pages.widgetsModulePtOne;

import com.automation.jQuery.bases.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class AccordionPage extends PageBase {

    @FindBy(css = ".ui-accordion-icons")
    private List<WebElement> accordionSections;

    @FindBy(xpath = "(//a[text()='Sortable'])[1]")
    private WebElement sortableSubBtn;

    public AccordionPage() {
        PageFactory.initElements(driver, this);
    }

    public AccordionPage accordSections(int beginningElem, int endElem) {
        logger.info("User sort accordion section");

        sortableSubBtn.click();
        waitUtil.wait(2);
        info("User cliked Sortable Button");

        frameUtil.iframeHandle(0);
        waitUtil.wait(1);
        info("Driver switched to iframe driver");

        sortUtil.sort(accordionSections, beginningElem, endElem);
        waitUtil.wait(2);
        info("User dragged the selected sections to target area");

        return this;
    }

    public void verifySortableItems(String expected, int expectedSectionIndex) {
        logger.info("Verifying the accordion sortable sections");

        String actual = accordionSections.get(expectedSectionIndex).getText();
        Assert.assertEquals(expected, actual);
        info("verify the actual section: " + actual + "with expected section: " + expected);

    }
}
