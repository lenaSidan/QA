package com.ait.pageOM.tests;

import com.ait.pageOM.pages.HoversPage;
import com.ait.pageOM.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHovers();
    }

    @Test
    public void hoverOverImageTest() {
        new HoversPage(driver).hoverOverImages(0).verifyNotFoundMessage();
    }
}
