package com.ait.pageOM.tests;

import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).navigateToSliderPage();
    }

    @Test
    public void sliderTest(){
        new SliderPage(driver).moveSliderHorizontalDirection()
                .assertToMoveSlider("5");
    }
}
