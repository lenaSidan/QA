package com.ait.pageOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "column-a")
    WebElement column_a;

    @FindBy (id = "column-b")
    WebElement column_b;

    public DroppablePage actionDragMe() {
        pause(1000);
        new Actions(driver).dragAndDrop(column_a, column_b).perform();
        return this;
    }


    public DroppablePage assertDropped(String originalTextA, String originalTextB) {

        Assert.assertEquals(originalTextB, column_a.getText());
        Assert.assertEquals(originalTextA, column_b.getText());
        return this;
    }

    public String getColumnAText() {
        return column_a.getText();
    }

    public String getColumnBText() {
        return column_b.getText();
    }

}
