package com.haveibeenpwned.pages;

import com.haveibeenpwned.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class Home extends Base {
    public Home() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Initializing the WebElements present in the Home page of haveibeenpwned
     */
    @FindBy(id = "Account")
    WebElement searchBar;

    @FindBy(id = "searchPwnage")
    WebElement pwnedButton;

    @FindBy(xpath = "//h2[contains(text(),'Oh no — pwned!')]")
    WebElement pwnedStatus;

    @FindBy(xpath = "//h2[contains(text(),'Good news — no pwnage found!')]")
    WebElement noPwnedStatus;

    /**
     * Method to verify that the Home page of haveibeenpwned is completely loaded
     */
    public void verifyHome() {
        try {
            Assert.assertTrue(searchBar.isDisplayed(), "Email Search Bar is not displayed properly");
        } catch (Exception e) {
            Assert.assertTrue(false, "haveibeenpwned Home Page is not loaded properly");
        }
    }

    /**
     * Method to search an email using the Email Search bar
     */
    public void searchEmail(String emailID) {

        try {
            searchBar.click();
            searchBar.clear();
            searchBar.sendKeys(emailID);
            pwnedButton.click();
        } catch (Exception e) {
            Assert.assertTrue(false, "Unable to provide values to the email Search bar");
        }

    }

    /**
     * Method to verify the status of the emailID
     */
    public void verifyStatus(String emailID) {

        try {
            if (checkVisible(pwnedStatus)) {
                Reporter.log("Email ID " + emailID + " is pwned!!", true);
            } else if (checkVisible(noPwnedStatus)) {
                Reporter.log("Email ID " + emailID + " is not pwned!!", true);
            } else {
                Assert.assertTrue(false, "Some error happened");
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Unable to check the status of the emailID");
        } finally {
            driver.navigate().refresh();
        }

    }

}
