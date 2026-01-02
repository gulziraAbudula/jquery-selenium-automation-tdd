package com.automation.jQuery.bases;

import com.automation.jQuery.utility.dataRelated.JsonReaderUtil;
import com.automation.jQuery.utility.dataRelated.XLReaderUtil;
import com.automation.jQuery.utility.reportRelated.TestListener;
import com.automation.jQuery.utility.webActionRelated.BrowserUtil;
import org.testng.annotations.*;

public class TestBase extends TestListener {

    protected XLReaderUtil xlRead = new XLReaderUtil();
    protected JsonReaderUtil jsonUtil = new JsonReaderUtil();

    @BeforeSuite
    public void beforeEachSuite() {
    }

    @BeforeTest
    public void beforeEachTest() {

    }

    @BeforeClass
    public void beforeEachClass() {
        onExtentSetup();
    }

    @BeforeMethod
    // @Parameters("browser")
    public void beforeEachMethod() {

        String browser = System.getProperty("browser");
        String executionMode = System.getProperty("execution.mode", "local");

        // Dynamically invoke the appropriate method based on execution mode
        if ("docker".equalsIgnoreCase(executionMode)) {
            driver = BrowserUtil.startDockerContainerBrowser(browser);
        } else if ("private".equalsIgnoreCase(executionMode)) {
            driver = BrowserUtil.startBrowserInPrivateMode(browser);
        } else {
            // Default to regular browser mode
            driver = BrowserUtil.startBrowser(browser);
        }

        driver.get("https://jqueryui.com/");

        //        String browser = System.getProperty("browser");
////        driver = BrowserUtil.startBrowser(browser);
//        driver = BrowserUtil.startDockerContainerBrowser(browser);
//        //driver = BrowserUtil.startBrowser("chrome");
//        driver.get("https://jqueryui.com/");

        /*
         * System.out.println("Initiating Chrome Driver"); String driverPath =
         * System.getProperty("user.dir") +
         * "/src/test/resources/drivers/chromedriver.exe";
         * System.setProperty("webdriver.chrome.driver", driverPath); driver = new
         * ChromeDriver(); driver.manage().deleteAllCookies();
         * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         * driver.manage().window().maximize(); driver.get("https://jqueryui.com/");
         */
    }

    @AfterMethod
    public void AfterEachMethod() {
        // driver.close();
        driver.quit();
    }

    @AfterClass
    public void afterEachClass() {
        extent.flush();
    }

    @AfterTest
    public void afterEachTest() {

    }

    @AfterSuite
    public void afterEachSuite() {

    }
}
