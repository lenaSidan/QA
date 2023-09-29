package com.ait.pageOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage{

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@type='checkbox'][1]")
    WebElement checkbox1;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
    WebElement checkbox2;

    public CheckboxesPage selectCheckboxes(String[] checkboxes){
        for (String checkbox : checkboxes) {
            if (checkbox.equals("checkbox 1")) {
                if (!checkbox1.isSelected()) {
                    click(checkbox1);
                }
            } else if (checkbox.equals("checkbox 2")) {
                if (!checkbox2.isSelected()) {
                    click(checkbox2);
                }
            }
        }
        return this;
    }

    public boolean isCheckboxSelected(String checkboxName) {
        if (checkboxName.equals("checkbox 1")) {
            return checkbox1.isSelected();
        } else if (checkboxName.equals("checkbox 2")) {
            return checkbox2.isSelected();
        }
        return false;
    }

}
