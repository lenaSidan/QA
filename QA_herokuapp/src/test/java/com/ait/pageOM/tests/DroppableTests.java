package com.ait.pageOM.tests;

import com.ait.pageOM.pages.DroppablePage;
import com.ait.pageOM.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDrop();
    }


    @Test
    public void droppableTest() {
        DroppablePage droppablePage = new DroppablePage(driver);

        String originalTextA = droppablePage.getColumnAText();
        String originalTextB = droppablePage.getColumnBText();

        droppablePage
                .actionDragMe()
                .assertDropped(originalTextA, originalTextB);
    }


}
