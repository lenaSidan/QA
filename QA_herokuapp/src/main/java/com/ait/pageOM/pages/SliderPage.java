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
        pause(2000);
        new Actions(driver).dragAndDropBy(slider,65, 0).perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;

    public SliderPage assertToMoveSlider(String number) {
        Assert.assertEquals(getValueAttribute(range, "value"), number);
        return this;
    }
    private String getValueAttribute(WebElement element, String value) {

        return element.getAttribute(value);
    }


}

