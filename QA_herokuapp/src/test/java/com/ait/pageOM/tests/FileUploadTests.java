package com.ait.pageOM.tests;

import com.ait.pageOM.pages.FileUploadPage;
import com.ait.pageOM.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase{
    public static final String PATH = "C:/Users/lenas/OneDrive/Desktop/Maja/1.png";

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).navigateToFileUploadPage();
    }

    @Test
    public void FileUploadSuccessTest() {
        new FileUploadPage(driver).uploadFileAndCheckSuccess(PATH);
    }

    @Test
    public void FileUploadFailureTest() {
        new FileUploadPage(driver).submitWithoutFileAndCheckError();
    }

}
