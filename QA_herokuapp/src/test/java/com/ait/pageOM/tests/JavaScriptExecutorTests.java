package com.ait.pageOM.tests;


import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.JSExecutor;
import com.ait.pageOM.pages.data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFormAuthentication();
    }

    @Test
    public void jsExecutorTest() {
        new JSExecutor(driver)
                .enterDataWithJSExecutor(UserData.USER_NAME1, UserData.USER_PASSWORD1)
                .clickWithJS().checkURLWithJS().checkTitleOfPageWithJS();
    }
}
