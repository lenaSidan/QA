package demoWS.fw;

import demoWS.models.Contact;
import demoWS.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(.,'Log in')]"));
    }

    public void clickOnLogOutButton() {
        click(By.xpath("//a[contains(.,'Log out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(.,'Log in')]"));
    }

    public void clickOnGenderChoice() {
        click(By.xpath("//input[@id='gender-male']"));
        click(By.xpath("//input[@id='gender-female']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    public void clickOnRegistrationMenuButton() {
        click(By.xpath("//a[contains(.,'Register')]"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickOnRememberMeButton() {
        click(By.xpath("//label[contains(.,'Remember me?')]"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"),user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void fillLoginFormForScreenCast(User user) {
        type(By.id("Email"),user.getEmail());
        type(By.id("Password"), user.getPassword());
        pause(1000);
    }
    public void assertRegistrationSuccessful() {
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'Your registration completed')]")));
    }

    public void assertEmailAlreadyExists() {
        Assert.assertTrue(isElementPresent(By.xpath("//li[contains(.,'The specified email already exists')]")));
    }

    public void fillLoginRegisterForm(Contact contact) {
        type(By.xpath("//input[@id='FirstName']"), contact.getFirstName());
        type(By.xpath("//input[@id='LastName']"), contact.getLastName());
        type(By.xpath("//input[@id='Email']"), contact.getEmail());
        type(By.xpath("//input[@id='Password']"), contact.getPassword());
        type(By.xpath("//input[@id='ConfirmPassword']"), contact.getConfirmPassword());
    }


}
