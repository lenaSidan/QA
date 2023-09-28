
package com.ait.pageOM.pages;


import com.ait.pageOM.pages.alertWindows.AlertsPage;
import com.ait.pageOM.pages.alertWindows.IframesPage;
import com.ait.pageOM.pages.alertWindows.WindowsPage;
import com.ait.pageOM.pages.links.BrokenImages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public HomePage checkAllLinks() {
        String url;
        System.out.println("Total links on the page: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }


    @FindBy(xpath = "//a[.='Broken Images']")
    WebElement brokenImages;

    public BrokenImages getBrokenImages() {
        click(brokenImages);
        return new BrokenImages(driver);

    }


    @FindBy(id = "app")
    WebElement alertsFrameWindows;

    public AlertsPage getAFW() {
        click(alertsFrameWindows);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//a[@href='/javascript_alerts']")
    WebElement alerts;

    public AlertsPage getAlerts() {
        click((alerts));
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement windows;

    public WindowsPage getMultipleWindows() {
        click(windows);
        return new WindowsPage(driver);
    }


    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement form;

    public JSExecutor getFormAuthentication() {
        click(form);
        return new JSExecutor(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Nested Frames')]")
    WebElement frame;

    public IframesPage navigateToFramesPage() {
        click(frame);
        return new IframesPage(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'iFrame')]")
    WebElement iframeLink;

    public HomePage navigateToIframePage() {
        click(iframeLink);
        return this;
    }


    @FindBy(xpath = "//a[contains(text(),'Frames')]")
    WebElement mainFrameLink;

    public HomePage navigateToMainFramesPage() {
        click(mainFrameLink);
        return this;
    }


    @FindBy(xpath = "//a[contains(text(),'Horizontal Slider')]")
    WebElement horizontalSlider;

    public HomePage navigateToSliderPage() {
        click(horizontalSlider);
        return this;
    }


    @FindBy(xpath = "//a[text()='Checkboxes']")
    WebElement checkboxes;

    public HomePage navigateToCheckboxesPage() {
        click(checkboxes);
        return this;
    }

    @FindBy(xpath = "//a[text()='File Upload']")
    WebElement uploadFile;

    public HomePage navigateToFileUploadPage() {
        click(uploadFile);
        return this;
    }


    @FindBy(xpath = "//a[text()='Dropdown']")
    WebElement dropdown;

    public HomePage navigateToDropdownPage() {
        click(dropdown);
        return this;
    }
}
