package com.ait.phonebook;

import com.ait.phonebook.fw.DataProviders;
import com.ait.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().login();

        app.getContact().clickOnAddLink();
    }

    @Test
    public void addNewContactPositiveTest() {
        //fill in all input fields - input:nth-child(1) - css
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setSurname("Ludwig")
                .setPhone("1234567890")
                .setEmail("adam@web.com")
                .setAddress("Koblenz")
                .setDesc("goalkeeper"));
        //click on Save button - .add_form__2rsm2 button - css
        app.getContact().clickOnSaveButton();
        //assert new contact added - h2
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }



    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactPositiveFromDataProviderTest(String name, String surname, String phone,
                                                          String email, String address, String desc) {
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }



    @Test(dataProvider = "addNewContactFromCSV" , dataProviderClass = DataProviders.class)
    public void addNewContactPositiveFromDataProviderWithCSVTestTest(Contact contact) {
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()),"1");
    }

}
