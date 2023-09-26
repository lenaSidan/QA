package com.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        // click on login link -  //a[contains(.,'LOGIN')] -xpath
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {

        app.getUser().fillLoginRegisterForm(new User().setEmail("sany@web.de").setPassword("Sany$2006"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {

        app.getUser().fillLoginRegisterForm(new User().setEmail("sany@web.de"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreenCast() throws IOException, AWTException {
        app.getUser().deleteScreenCast("record");
        app.getUser().startRecording();

        app.getUser().fillLoginRegisterFormForScreenCast(new User()
                        .setEmail("sany@web.de")
                        .setPassword("Sany$2006"));

        app.getUser().clickOnLoginButton();
        app.getUser().pause(2000);

        app.getUser().stopRecording();
    }

}
