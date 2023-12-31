package com.ait.pageOM.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPage extends BasePage{

    public DropdownPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "dropdown")
    WebElement dropdownElement;

    public DropdownPage selectDropdown(String optionText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);

        return this;
    }

    public String getSelectedOption() {
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }
}
