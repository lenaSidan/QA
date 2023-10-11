package com.ait.demoqa.pages;

import com.ait.demoqa.pages.alertWindows.IframesPage;
import com.ait.demoqa.pages.bookStore.LoginPage;
import com.ait.demoqa.pages.bookStore.ProfilePage;
import com.ait.demoqa.pages.elements.ButtonsPage;
import com.ait.demoqa.pages.elements.TextBoxPage;
import com.ait.demoqa.pages.elements.UploadPage;
import com.ait.demoqa.pages.form.PracticeFormPage;
import com.ait.demoqa.pages.interactions.DroppablePage;
import com.ait.demoqa.pages.widgets.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SidePanel extends BasePage{




    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-0")
    WebElement login;

    public LoginPage selectLogin() {
        //click(login);
        clickWithJSExecutor(login, 0, 600);
        return new LoginPage(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profile;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile,0,100);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public IframesPage selectFrames() {
         clickWithJSExecutor(frames,0,400);
         return new IframesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public IframesPage selectNestedFrames(){
        clickWithJSExecutor(nestedFrames,  0, 400);
        return  new IframesPage(driver);
    }


    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons, 0, 300);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutoComplete() {
        clickWithJSExecutor(autoComplete,0, 300);
        return new AutoCompletePage(driver);
    }


    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJSExecutor(slider, 0, 500);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage selectSelectMenu() {
        clickWithJSExecutor(selectMenu,0,600);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        clickWithJSExecutor(practiceForm, 0, 200);
        return new PracticeFormPage(driver);
    }


    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        clickWithJSExecutor(menu,0,400);
        return  new MenuPage(driver);
    }


    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage selectToolTips() {
        clickWithJSExecutor(toolTips,0,600);
        return new ToolTipsPage(driver);
    }


    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;

    public DroppablePage selectDroppable() {
        clickWithJSExecutor(droppable,0,600);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement upload;

    public UploadPage getUpload() {
        clickWithJSExecutor(upload,0,400);
        return new UploadPage(driver);
    }
}
