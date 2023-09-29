package com.ait.pageOM.tests;

import com.ait.pageOM.pages.CheckboxesPage;
import com.ait.pageOM.pages.HomePage;
import org.testng.Assert;
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
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver).selectCheckboxes(CHECKBOXES);
        for (String checkbox : CHECKBOXES) {
            Assert.assertTrue(checkboxesPage.isCheckboxSelected(checkbox), checkbox + " is not selected as expected.");
        }
    }
}


