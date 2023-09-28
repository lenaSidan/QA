package com.ait.pageOM.tests;

import com.ait.pageOM.pages.DropdownPage;
import com.ait.pageOM.pages.HomePage;
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
        new DropdownPage(driver).selectDropdown(DROPDOWN);
    }

}

