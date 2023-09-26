package com.ait.phonebook;

import com.ait.phonebook.fw.ApplicationManger;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManger app = new ApplicationManger(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void  startTest(Method m, Object[] p){
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: " + result.getMethod().getMethodName() +
                    "Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop Test");
        logger.info("*********************************************************");
    }

}
