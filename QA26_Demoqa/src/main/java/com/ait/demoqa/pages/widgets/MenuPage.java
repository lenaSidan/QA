package com.ait.demoqa.pages.widgets;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;
    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;
    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    WebElement subSubItem2;

    public MenuPage openSubMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();

        actions.moveToElement(subSubList).perform();

        actions.moveToElement(subSubItem2).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(subSubItem2));
        return this;
    }

    public MenuPage assertSubItem() {
        Assert.assertTrue(subSubItem2.isDisplayed());
        return this;
    }
}