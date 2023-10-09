package com.ait.pageOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".figure img")
    List<WebElement> images;

    @FindBy(css = ".figcaption a")
    List<WebElement> profileLinks;

    @FindBy(tagName = "h1")
    WebElement heading;

    public HoversPage hoverOverImages(int i) {

        new Actions(driver).moveToElement(images.get(i)).perform();
        profileLinks.get(i).click();
        return this;
    }

    public HoversPage verifyNotFoundMessage() {
        Assert.assertEquals("Not Found", heading.getText());
        return this;
    }
}
