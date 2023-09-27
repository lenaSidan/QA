package com.ait.pageOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends BasePage{

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='range']")
    WebElement slider;


    public SliderPage moveSliderHorizontalDirection() {
        pause(1000);
        new Actions(driver).dragAndDropBy(slider,65, 0).perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;

    public SliderPage assertToMoveSlider(String number) {
        Assert.assertTrue(isTextPresent(range, number));
        return this;
    }



}

