package com.ait.pageOM.tests.links;



import com.ait.pageOM.pages.HomePage;
import com.ait.pageOM.pages.links.BrokenImages;
import com.ait.pageOM.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        new HomePage(driver).checkAllLinks()
                .getBrokenImages();
    }

    @Test
    public void checkBrokenImagesTest(){

        new BrokenImages(driver).checkBrokenImages();
    }
}
