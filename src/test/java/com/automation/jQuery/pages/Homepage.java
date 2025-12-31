package com.automation.jQuery.pages;

import com.automation.jQuery.bases.PageBase;
import com.automation.jQuery.pages.effectsModule.AddClassPage;
import com.automation.jQuery.pages.utilityModule.PositionPage;
import com.automation.jQuery.pages.utilityModule.WidgetsFactoryPage;
import com.automation.jQuery.pages.widgetsModulePtOne.ControlGroupPage;
import org.dom4j.Document;
import org.openqa.selenium.By;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class Homepage extends PageBase {

    Document document = xmlReader.getData("/src/test/resources/locators/locators.xml");

    private By draggable = By.xpath(document.selectSingleNode("//Pages/Homepage/draggableBtn").getText());
    private By droppable = By.xpath(document.selectSingleNode("//Pages/Homepage/droppableBtn").getText());
    private By resizable = By.xpath(document.selectSingleNode("//Pages/Homepage/resizableBtn").getText());
    private By selectable = By.xpath(document.selectSingleNode("//Pages/Homepage/selectableBtn").getText());
    private By sortable = By.xpath(document.selectSingleNode("//Pages/Homepage/sortableBtn").getText());

    private By accordion = By.xpath(document.selectSingleNode("//Pages/Homepage/accordionBtn").getText());
    private By autocomplete = By.xpath(document.selectSingleNode("//Pages/Homepage/autocompleteBtn").getText());
    private By checkBoxRadio = By.xpath(document.selectSingleNode("//Pages/Homepage/checkBoxRadioBtn").getText());

    private By datepicker = By.xpath(document.selectSingleNode("//Pages/Homepage/datePickerBtn").getText());
    private By selectMenu = By.xpath(document.selectSingleNode("//Pages/Homepage/selectmenuBtn").getText());
    private By spinner = By.xpath(document.selectSingleNode("//Pages/Homepage/spinnerBtn").getText());
    private By addClass = By.xpath(document.selectSingleNode("//Pages/Homepage/addClassBtn").getText());
    private By colorAnimation = By.xpath(document.selectSingleNode("//Pages/Homepage/colorAnimationBtn").getText());
    private By processorBar = By.xpath(document.selectSingleNode("//Pages/Homepage/processerBarBtn").getText());
    private By dialog = By.xpath(document.selectSingleNode("//Pages/Homepage/dialogBtn").getText());
    private By position = By.xpath(document.selectSingleNode("//Pages/Homepage/positionBtn").getText());
    private By widgetsFactory = By.xpath(document.selectSingleNode("//Pages/Homepage/widgetsFactoryBtn").getText());
    private By controlGroup = By.xpath(document.selectSingleNode("//Pages/Homepage/controlGroupBtn").getText());
    private By tab = By.xpath(document.selectSingleNode("//Pages/Homepage/tabBtn").getText());

    public void clickDragBtn() {
        logger.info("User click Draggable Button");
        webElem.click(draggable);
        waitUtil.wait(2);
        info("User click Draggable Button");
    }

    public void clickDropBtn() {
        logger.info("User click Droppable button");
        webElem.click(droppable);
        waitUtil.wait(2);
        info("User click Droppable Button");
    }

    public void clickResizeBtn() {
        logger.info("User click Resizable button");
        webElem.click(resizable);
        waitUtil.wait(2);
        info("User click Resizable Button");
    }

    public void clickSelectBtn() {
        logger.info("User click Selectable button");
        webElem.click(selectable);
        waitUtil.wait(2);
        info("User click Selectable Button");
    }

    public void clickSortBtn() {
        logger.info("User click Sortable button");
        webElem.click(sortable);
        waitUtil.wait(2);
        info("User click Sortable Button");
    }

    public void clickAccordBtn() {
        logger.info("User click Accordion Button");
        webElem.click(accordion);
        waitUtil.wait(2);
        info("User click Accordion Button");
    }

    public void clickAutocompleteBtn() {
        logger.info("User click Autocomplete Button");
        webElem.click(autocomplete);
        waitUtil.wait(2);
        info("User click Autocomplete Button");
    }

    public void clickCheckBoxRadioBtn() {
        logger.info("User click Checkboxradio Button");
        webElem.click(checkBoxRadio);
        waitUtil.wait(2);
        info("User click Checkboxradio Button");
    }

    public void clickDatepickerBtn() {
        logger.info("User click Datepicker Button");
        webElem.click(datepicker);
        waitUtil.wait(2);
        info("User click DatePicker Button");
    }

    public void clickSelectMenuBtn() {
        logger.info("User click Menu Button");
        webElem.click(selectMenu);
        waitUtil.wait(2);
        info("User click Menu Button");
    }

    public void clickSpinnerBtn() {
        logger.info("User click Spinner button");
        webElem.click(spinner);
        waitUtil.wait(2);
        info("User click Spinner Button");
    }

    public AddClassPage clickAddClassBtn() {
        logger.info("User click Add Class button");
        webElem.click(addClass);
        waitUtil.wait(2);
        info("User click Add Class Button");
        return new AddClassPage();
    }

    public void clickColorAnimationBtn() {
        logger.info("User click Add Class button");
        webElem.click(colorAnimation);
        waitUtil.wait(2);
        info("User click Color Animation Button");
    }

    public void clickProcessorBarBtn() {
        logger.info("User click Processorbar button");
        webElem.click(processorBar);
        waitUtil.wait(2);
        info("User click Processorbar Button");
    }

    public void clickDialogBtn() {
        logger.info("User click Dialog button");
        webElem.click(dialog);
        waitUtil.wait(2);
        info("User click Dialog Button");
    }

    public PositionPage clickPositionBtn() {
        logger.info("User click Position button");
        webElem.click(position);
        waitUtil.wait(2);
        info("User click Position Button");
        return new PositionPage();
    }

    public WidgetsFactoryPage clickWidgetsFactoryBtn() {
        logger.info("User click Widgets Factory button");
        webElem.click(widgetsFactory);
        waitUtil.wait(2);
        info("User click Widgets Factory Button");
        return new WidgetsFactoryPage();
    }

    public ControlGroupPage clickControlGroupBtn() {
        logger.info("User click Control Group button");
        webElem.click(controlGroup);
        waitUtil.wait(2);
        info("User click Control Group Button");
        return new ControlGroupPage();
    }

    public void clickTabBtn() {
        logger.info("User click Tab button");
        webElem.click(tab);
        waitUtil.wait(2);
        info("User click Tab Button");
    }
}
