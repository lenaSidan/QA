
package com.ait.pageOM.pages;


import com.ait.pageOM.pages.alertWindows.AlertsPage;
import com.ait.pageOM.pages.alertWindows.WindowsPage;
import com.ait.pageOM.pages.links.BrokenImages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage{
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
        click( brokenImages);
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

    public AlertsPage getAlerts(){
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

}
