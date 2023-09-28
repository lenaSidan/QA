package com.ait.pageOM.tests;

import com.ait.pageOM.pages.CheckboxesPage;
import com.ait.pageOM.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestBase{
    public static final String[] CHECKBOXES = {"checkbox 1", "checkbox 2"};
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).navigateToCheckboxesPage();
    }

    @Test
    public void checkboxesTest() {
        new CheckboxesPage(driver).selectCheckboxes(CHECKBOXES);
    }

}


