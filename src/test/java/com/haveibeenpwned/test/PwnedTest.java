package com.haveibeenpwned.test;

import com.haveibeenpwned.common.Base;
import com.haveibeenpwned.pages.Home;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PwnedTest extends Base {

    /**
     * Method to the open the application
     */
    @BeforeTest
    public void startTest() {

        try {
            startDriver();
            openAppURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to test the successful search result in Google
     */

    @Test(description = "Test Case: Verify whether the list of Email IDs are pwned or not")
    public void verifyPwnedStatus() {
        Home homePage = new Home();

        homePage.verifyHome();
        for (String emailID : emailIDList) {
            homePage.searchEmail(emailID);
            homePage.verifyStatus(emailID);
        }
    }

    /**
     * Method to close the browser
     */

    @AfterTest
    public void endTest() {
        exitDriver();
    }
}
