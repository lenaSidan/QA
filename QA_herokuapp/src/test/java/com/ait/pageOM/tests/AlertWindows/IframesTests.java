package com.ait.pageOM.tests.AlertWindows;

import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.alertWindows.IframesPage;
import com.ait.pageOM.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver)
                .navigateToMainFramesPage();
    }

    @Test
    public void iframesTest() {
        new HomePage(driver)
                .navigateToFramesPage()
                .returnListOfIframes()
                .switchToFrameByIndex(1);
    }

    @Test
    public void switchToFrameByIndexTest() {
        int indexToSwitch = 1;
        new HomePage(driver)
                .navigateToFramesPage()
                .switchToFrameByIndex(indexToSwitch);
    }

    @Test
    public void switchToNestedIframesTest() {
        new HomePage(driver).navigateToFramesPage();
        new IframesPage(driver).switchToNestedIframe();
    }

    @Test
    public void editAndVerifyIframeContent() {
        new HomePage(driver).navigateToIframePage();
        String content = "Test iFrame content";
        new IframesPage(driver)
                .editIframeContent(content)
                .verifyIframeContent(content);
    }
}
