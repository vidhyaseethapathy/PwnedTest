package com.haveibeenpwned.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public InputStream inputStream;
    public String[] emailIDList;

    /**
     * Method to start the browser and maximize the screen
     */
    public void startDriver() throws Exception {
        Thread.sleep(10000);
        String host = System.getProperty("seleniumHubHost");
        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), new ChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Method to read URL and Product from the Properties file to the browser
     *
     * @throws IOException
     */
    public void openAppURL() throws IOException {
        inputStream = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src"
                + File.separator + "main" + File.separator + "resources" + File.separator + "app.properties"));
        Properties appProperties = new Properties();
        appProperties.load(inputStream);
        driver.get(appProperties.getProperty("URL"));
        emailIDList = appProperties.getProperty("IDList").split("\\|");
        inputStream.close();
    }

    /**
     * Method to exit the browser
     */

    public void exitDriver() {
        driver.quit();
    }

    /**
     * Method to check Visibility
     */

    public Boolean checkVisible(WebElement element) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}