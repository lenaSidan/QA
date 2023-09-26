package demoWS;

import demoWS.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().fillLoginForm(new User().setEmail("woz@web.de").setPassword("olf$2006"));
        app.getUser().clickOnRememberMeButton();
        app.getUser().clickOnLoginButton();
        app.getUser().clickOnLogOutButton();

    }

    @Test
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().fillLoginForm(new User().setEmail("woz@web.de"));
        app.getUser().clickOnRememberMeButton();
        app.getUser().clickOnLoginButton();



    }

    @Test
    public void loginPositiveTestWithScreenCast() throws IOException, AWTException {
        app.getUser().deleteScreenCast("record");
        app.getUser().startRecording();

        app.getUser().fillLoginFormForScreenCast(new User()
                .setEmail("woz@web.de")
                .setPassword("olf$2006"));

        app.getUser().clickOnRememberMeButton();
        app.getUser().clickOnLoginButton();
        app.getUser().clickOnLogOutButton();

        app.getUser().pause(2000);

        app.getUser().stopRecording();
    }

}

