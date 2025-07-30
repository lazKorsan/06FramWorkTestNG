package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.TestloginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_testLogin {

    @Test
    public void loginTestiSayfasi(){
        Driver.getDriver().get(ConfigReader.getProperty("peTestToolsUrl"));

        TestloginPage testloginPage = new TestloginPage();

        testloginPage.TestLoginPagesButtons.click();
        ReusableMethods.bekle(3);

        testloginPage.userNameBox.sendKeys("practice");
        testloginPage.passWordBox.sendKeys("SuperSecretPassword!");
        testloginPage.loginButtons.click();
        ReusableMethods.bekle(5);

        testloginPage.flashText.isEnabled();
        ReusableMethods.getWebElementScreenshot(testloginPage.flashText,"flashText Yazisi");

        testloginPage.logOutButtons.click();



        Driver.quitDriver();


    }
}
