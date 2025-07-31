package tests.PracticeExpandtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.ForgotpasswordPages;
import pages.TestregistarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C11_forgotPasswordForm {

    @Test
    public void forgotpaswwordform(){

        Driver.getDriver().get(ConfigReader.getProperty("forgotpaswwordUrl"));

        ForgotpasswordPages forgotpasswordPages = new ForgotpasswordPages() ;
        TestregistarPage testregistarPage = new TestregistarPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", forgotpasswordPages.emailBox);
        forgotpasswordPages.emailBox.sendKeys("hellowORLD@gmail.com");

        forgotpasswordPages.retrievePasswordButton.click();

        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.flashText,"flashtazisi");

        ReusableMethods.bekle(3);


    }
}
