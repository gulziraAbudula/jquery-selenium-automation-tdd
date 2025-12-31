package com.automation.jQuery.bases;

import com.automation.jQuery.utility.dataRelated.XMLReaderUtil;
import com.automation.jQuery.utility.reportRelated.TestListener;
import com.automation.jQuery.utility.webActionRelated.*;

public class PageBase extends TestListener {

    protected WaitUtil waitUtil = new WaitUtil(driver);
    protected AssertUtil assertUtil = new AssertUtil(driver);
    protected XMLReaderUtil xmlReader = new XMLReaderUtil();
    protected WebElementUtil webElem = new WebElementUtil(driver);
    protected DragAndDropUtil dNdUtil = new DragAndDropUtil(driver);
    protected IframeHandlingUtil frameUtil = new IframeHandlingUtil(driver);
    protected ResizableUtil resizeUtil = new ResizableUtil(driver);
    protected SelectableMultipleItemsUtil selectUtil = new SelectableMultipleItemsUtil(driver);
    protected DragAndSortUtil sortUtil = new DragAndSortUtil(driver);
    protected AutocompleteUtil autoUtil = new AutocompleteUtil(driver);
    protected ScrollDownUpUtil scrollUtil = new ScrollDownUpUtil(driver);
    protected RadioButtonClickingUtil radioUtil = new RadioButtonClickingUtil(driver);
    protected SelectCheckBoxUtil checkBoxUtil = new SelectCheckBoxUtil(driver);
    protected DatePickerUtil dateUtil = new DatePickerUtil(driver);
    protected SelectDropDownUtil selectDropdownUtil = new SelectDropDownUtil(driver);
    protected AlertHandlerUtil alertUtil = new AlertHandlerUtil(driver);
    protected ClickSpinnerUtil spinnerUtil = new ClickSpinnerUtil(driver);
    protected WaitForFileDownloadUtil waitTillDownloadUtil = new WaitForFileDownloadUtil(driver);
}
