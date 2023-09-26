package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.alertWindows.AlertsPage;
import com.ait.demoqa.tests.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAFW();
        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptAlertTest() {
        new AlertsPage(driver).acceptAlert();
    }

    @Test
    public void timerAlertButtonTest() {
        new AlertsPage(driver).acceptAlertInFiveSecond();
    }

    @Test
    public void confirmAlertTest() {
        new AlertsPage(driver).confirmAlert("cancel");
    }

    @Test
    public void sendTextToAlertTest() {
        new AlertsPage(driver).sendTextToAlert("Guten Tag!")
                .assertAcceptAlert("Guten Tag!");
    }
}
