package com.ait.phonebook;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewUserTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    // precondition: user should be logged out

    @Test
    public void createNewUserNegativeTest() {

        app.getUser().fillLoginRegisterForm(new User().setEmail("sany@web.de").setPassword("Sany$2006"));
        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        // assert Sing out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
