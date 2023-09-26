package com.ait.pageOM.pages.links;


import com.ait.pageOM.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImages extends BasePage {

    public BrokenImages(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenImages checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");

        for (int index = 0; index < images.size(); index++) {
            WebElement image = images.get(index);
            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is: " + imageUrl);
            verifyLinks(imageUrl);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof argument[0].naturalWith!=undefined && arguments[0].naturalWith>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAYED - OK");
                    System.out.println("*******************************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("*******************************************");

                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }
        return this;
    }

}