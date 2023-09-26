package com.ait.pageOM.tests.AlertWindows;


import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.alertWindows.WindowsPage;
import com.ait.pageOM.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowsTests extends TestBase {

    @BeforeMethod
    public void precondition()  {
        new HomePage(driver).getMultipleWindows();
    }

    @Test
    public void newTabTest() {
        new WindowsPage(driver).switchToNewTab(1)
                .assertNewTab("New Window");
    }
}
