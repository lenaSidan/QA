package com.ait.demoqa.pages.widgets;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement slider;

    public SliderPage moveSliderInHorizontalDirection() {
        pause(1000);
        new Actions(driver).dragAndDropBy(slider, 295, 0).perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage assertToMoveSlider(String number) {
        Assert.assertEquals(getValueAttribute(sliderValue, "value"), number);
        return this;
    }

    private String getValueAttribute(WebElement element, String value) {

        return element.getAttribute(value);
    }
}
