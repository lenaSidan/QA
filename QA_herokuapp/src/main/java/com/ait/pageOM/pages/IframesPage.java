package com.ait.pageOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

import java.util.List;


public class IframesPage extends BasePage {

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public IframesPage returnListOfIframes() {
        // print numbers of iframes using tag name
        System.out.println("The total number of frames on the page: " + iframes.size());

        // by executing js
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberIframes = Integer.parseInt(js.executeScript("return window.length;").toString());
        System.out.println("The total number of frames on the page " + numberIframes);
        return this;
    }

    public IframesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Invalid index. There are " + iframes.size() + " iframes available.");
        return this;
    }

    @FindBy(xpath = "//frame[@name='frame-top']")
    WebElement topFrame;

    @FindBy(xpath = "//frame[@name='frame-left']")
    WebElement leftFrame;

    @FindBy(xpath = "//frame[@name='frame-middle']")
    WebElement middleFrame;

    @FindBy(xpath = "//frame[@name='frame-right']")
    WebElement rightFrame;

    @FindBy(xpath = "//frame[@name='frame-bottom']")
    WebElement bottomFrame;
    @FindBy(tagName = "body")
    WebElement body;

    public IframesPage switchToNestedIframe() {
        driver.switchTo().frame(topFrame);

        driver.switchTo().frame(leftFrame);
        System.out.println("Inside frame-left");
        System.out.println("Frame-left is " + body.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(middleFrame);
        System.out.println("Inside frame-middle: " + driver.findElement(By.id("content")).getText());
        System.out.println("Frame-middle is " + body.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(rightFrame);
        System.out.println("Inside frame-right");
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(bottomFrame);
        System.out.println("Inside frame-bottom: " + driver.findElement(By.tagName("body")).getText());

        System.out.println("The total number of iframes in the child iframe: " + iframes.size());
        System.out.println("The total number of frames on the page " + iframes.size());
        System.out.println("The total number of iframes in the parent iframe: " + iframes.size());

        driver.switchTo().defaultContent();

        return this;
    }


    @FindBy(id="mce_0_ifr")
    WebElement iframeElement;

    @FindBy(id="tinymce")
    WebElement editor;

    public IframesPage editIframeContent(String content) {
        driver.switchTo().frame(iframeElement);
        editor.clear();
        editor.sendKeys(content);
        driver.switchTo().defaultContent();
        return this;
    }
    public IframesPage verifyIframeContent(String expectedContent) {
        driver.switchTo().frame(iframeElement);
        String actualContent = editor.getText();
        Assert.assertEquals(actualContent, expectedContent, "The content in the iFrame doesn't match expected.");
        driver.switchTo().defaultContent();
        return this;
    }
}
