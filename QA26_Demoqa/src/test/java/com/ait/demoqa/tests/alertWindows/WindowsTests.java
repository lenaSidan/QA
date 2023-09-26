package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.alertWindows.WindowsPage;
import com.ait.demoqa.tests.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAFW();
        new HomePage(driver).getBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new WindowsPage(driver)
                .switchToNewTab(1)
                .assertNewTab("This is a sample page");
    }

    @Test
    public void newWindowTest() {
        new WindowsPage(driver)
                .switchToNewWindow()
                .assertNewTab("This is a sample page");
    }



}
