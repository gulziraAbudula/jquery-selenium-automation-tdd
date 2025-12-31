package com.automation.jQuery.utility.webActionRelated;

import com.automation.jQuery.bases.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.automation.jQuery.utility.reportRelated.Log4jManager.error;
import static com.automation.jQuery.utility.reportRelated.Log4jManager.info;

public class BrowserUtil extends TestBase {

    public static WebDriver startBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome"))
                return startChromeBrowser();
            else if (browserName.equalsIgnoreCase("firefox"))
                return startFirefoxBrowser();
            else
                throw new Exception("ERROR!! You choose '" + browserName + "'. Currently supporting browsers are 'Chrome' and 'Firefox'");
        } catch (Exception ex) {
            error("something went wrong at startBrowser");
            ex.printStackTrace();
        }
        return null;
    }

    public static WebDriver startBrowserInPrivateMode(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome"))
                return startChromeBrowserInPrivateMode();
            else if (browserName.equalsIgnoreCase("firefox"))
                return startFirefoxBrowserInPrivateMode();
            else
                throw new Exception("ERROR!! You choose '" + browserName + "'. Currently supporting browsers are 'Chrome' and 'Firefox'");
        } catch (Exception ex) {
            error("something went wrong at startBrowserInPrivateMode()");
            ex.printStackTrace();
        }
        return null;
    }

    public static WebDriver startDockerContainerBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome"))
                return startDockerContainerChromeBrowser();
            else if (browserName.equalsIgnoreCase("firefox"))
                return startDockerContainerFirefoxBrowser();
            else
                throw new Exception("ERROR!! You choose '" + browserName + "'. Currently supporting browsers are 'Chrome' and 'Firefox'");
        } catch (Exception ex) {
            error("something went wrong at startDockerContainerBrowser()");
            ex.printStackTrace();
        }
        return null;
    }

    private static WebDriver startChromeBrowser() {
        System.out.println("Initiating Chrome Driver");
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Chrome Driver");
            ex.printStackTrace();
        }
        info("Successfully Initiated Chrome Driver");
        return driver;
    }

    private static WebDriver startFirefoxBrowser() {
        System.out.println("Initiating Firefox Driver");
        try {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Firefox Driver");
            ex.printStackTrace();
        }
        info("Successfully Initiated Firefox Driver");
        return driver;
    }

    private static WebDriver startChromeBrowserInPrivateMode() {
        System.out.println("Initiating Chrome Driver in Incognito Mode");
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Chrome Driver in private mode");
            ex.printStackTrace();
        }
        info("Successfully Initiated Chrome Driver in private mode");
        return driver;
    }

    private static WebDriver startFirefoxBrowserInPrivateMode() {
        System.out.println("Initiating Firefox Driver in Private Mode");
        try {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driver = new FirefoxDriver(options);
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Firefox Driver in private mode");
            ex.printStackTrace();
        }
        info("Successfully Initiated Firefox Driver in private mode");
        return driver;
    }

    private static WebDriver startDockerContainerChromeBrowser() {
        System.out.println("Initiating Chrome Driver in Docker Container");
        try {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("timeoutInSeconds", 600);

            driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), options);
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Chrome Driver in Docker");
            ex.printStackTrace();
        }
        info("Successfully Initiated Chrome Driver in Docker Container");
        return driver;
    }

    private static WebDriver startDockerContainerFirefoxBrowser() {
        System.out.println("Initiating Firefox Driver in Docker Container");
        try {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("timeoutInSeconds", 120);

            driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), options);
            configureDriver();
        } catch (Exception ex) {
            error("Failed to initialize Firefox Driver in Docker");
            ex.printStackTrace();
        }
        info("Successfully Initiated Firefox Driver in Docker Container");
        return driver;
    }

    private static void configureDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}