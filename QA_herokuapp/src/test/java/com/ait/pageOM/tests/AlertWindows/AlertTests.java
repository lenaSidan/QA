package com.ait.pageOM.tests.AlertWindows;

import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.alertWindows.AlertsPage;
import com.ait.pageOM.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptAlertTest() {
        new AlertsPage(driver).acceptAlert()
                .assertAcceptAlert("You successfully clicked an alert");
    }

    @Test
    public void confirmAlertTest() {
        new AlertsPage(driver).confirmAlert("cancel")
                .assertAcceptAlert("Cancel");
    }

    @Test
    public void sendTextToAlertTest() {
        new AlertsPage(driver).sendTextToAlert("Guten Tag!")
                .assertAcceptAlert("Guten Tag!");
    }
}