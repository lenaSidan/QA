package demoWS;

import demoWS.fw.DataProviders;
import demoWS.models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CreateNewUserTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void createExistedUserNegativeTest() {

        app.getUser().clickOnRegistrationMenuButton();
        app.getUser().clickOnGenderChoice();

        app.getUser().fillLoginRegisterForm(new Contact()
                .setFirstName("Olaf")
                .setLastName("Woz")
                .setEmail("woz@web.de")
                .setPassword("olf$2006")
                .setConfirmPassword("olf$2006"));

        app.getUser().clickOnRegistrationButton();
        app.getUser().assertEmailAlreadyExists();

    }

    @Test(dataProvider = "createNewUser", dataProviderClass = DataProviders.class)
    public void createExistedUserNegativeFromDataProviderTest(String firstName, String lastName, String email,
                                                              String password, String confirmPassword) {

        app.getUser().clickOnRegistrationMenuButton();
        app.getUser().clickOnGenderChoice();

        app.getUser().fillLoginRegisterForm(new Contact()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));

        app.getUser().clickOnRegistrationButton();
        

    }

    @Test(dataProvider = "createExistedUserFromCSV", dataProviderClass = DataProviders.class)
    public void createExistedUserNegativeFromDataProviderWithCSVTest(Contact contact) {

        app.getUser().clickOnRegistrationMenuButton();
        app.getUser().clickOnGenderChoice();

        app.getUser().fillLoginRegisterForm(contact);

        app.getUser().clickOnRegistrationButton();

    }

}