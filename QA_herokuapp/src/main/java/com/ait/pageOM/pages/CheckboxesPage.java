package com.ait.pageOM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage{

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "checkboxes")
    WebElement checkbox;

    public CheckboxesPage selectCheckboxes(String[] checkboxes){
        for (int i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].equals("checkbox 1")){
                click(checkbox);
            } if (checkboxes[i].equals("checkbox 2")) {
                click(checkbox);
            }
        }
        return this;
    }

}
