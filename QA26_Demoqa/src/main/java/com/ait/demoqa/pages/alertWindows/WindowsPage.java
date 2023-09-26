package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "tabButton")
    WebElement tabButton;

    public WindowsPage switchToNewTab(int index) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }


    @FindBy(id = "sampleHeading")
    WebElement title;

    public WindowsPage assertNewTab(String text) {
        Assert.assertTrue(shouldHaveText(title, text, 5));

        return this;
    }


    @FindBy(id = "windowButton")
    WebElement windowButton;

    public WindowsPage switchToNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        click(windowButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

}