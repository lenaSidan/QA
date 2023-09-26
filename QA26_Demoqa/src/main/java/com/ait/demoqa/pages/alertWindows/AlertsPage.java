package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "promtButton")
    WebElement prompt;

    public AlertsPage sendTextToAlert(String text) {
        click(prompt);

        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement result;

    public AlertsPage assertAcceptAlert(String message) {
        Assert.assertTrue(isTextPresent(result, message));
        return this;
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    public AlertsPage acceptAlert() {
        click(alertButton);

        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage acceptAlertInFiveSecond() {
        click(timerAlertButton);

        return this;
    }

    @FindBy(id= "confirmButton")
    WebElement confirm;

    public AlertsPage confirmAlert(String text) {
        click(confirm);

        if(text != null && text.equalsIgnoreCase("ok")) {
            driver.switchTo().alert().accept();
        } else if (text!= null && text.equalsIgnoreCase("cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
}
