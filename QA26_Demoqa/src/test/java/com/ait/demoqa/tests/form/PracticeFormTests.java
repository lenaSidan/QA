package com.ait.demoqa.tests.form;

import com.ait.demoqa.data.StudentData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.form.PracticeFormPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeFormTest() {
        // enter personal data
        new PracticeFormPage(driver).hideIframes();

        new PracticeFormPage(driver).enterPersonalData(
                StudentData.FIRST_NAME,
                StudentData.LAST_NAME,
                StudentData.EMAIL,
                StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                .selectData(StudentData.DATE_OF_BIRTH)
                .addSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBY)
                .uploadFile(StudentData.PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY);
               // .selectForm();
    }
}

