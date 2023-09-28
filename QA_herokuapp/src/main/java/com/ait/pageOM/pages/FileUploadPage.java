package com.ait.pageOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class FileUploadPage extends BasePage{

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="file-upload")
    WebElement uploadPicture;

    @FindBy(id = "file-submit")
    WebElement submit;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    WebElement uploadSuccessMessage;

    @FindBy(css = "#uploaded-files")
    WebElement uploadedFileName;

    public FileUploadPage uploadFileAndCheckSuccess(String path) {
        uploadPicture.sendKeys(path);
        click(submit);

        if(isElementPresent(By.xpath("//div[text()='Internal Server Error']"))) {
            Assert.fail("Internal Server Error occurred while uploading the file.");
        }

        Assert.assertTrue(uploadSuccessMessage.isDisplayed(), "File Uploaded! message is not displayed");

        String expectedFileName = new File(path).getName();
        Assert.assertEquals(uploadedFileName.getText(), expectedFileName, "Internal Server Error");

        return this;
    }

    public FileUploadPage submitWithoutFileAndCheckError() {
        click(submit);

        if(!isElementPresent(By.xpath("//h1[text()='Internal Server Error']"))) {
            Assert.fail("Expected error message 'Internal Server Error' not displayed.");
        }

        return this;
    }
}
