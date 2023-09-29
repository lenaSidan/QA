package com.ait.pageOM.tests;

import com.ait.pageOM.pages.DropdownPage;
import com.ait.pageOM.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase{
    public static final String DROPDOWN = "Option 2";

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).navigateToDropdownPage();
    }

    @Test
    public void DropdownPageTest() {
        DropdownPage dropdownPage = new DropdownPage(driver).selectDropdown(DROPDOWN);
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, DROPDOWN, "The selected option does not match the expected option.");
    }


}

