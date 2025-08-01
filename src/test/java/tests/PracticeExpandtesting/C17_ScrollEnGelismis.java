package tests.PracticeExpandtesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotpasswordPages;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.GelismisEkranKaydirmaMethodu;
import utilities.ReusableMethods;

public class C17_ScrollEnGelismis {
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

        new GelismisEkranKaydirmaMethodu(practiceexpandtestingPage.oneTimePasswordButtons)
                .withOffset(100)
                .withSpeed(300)
                .withRetry(3)
                .withScreenshotOnFail()
                .execute();
        practiceexpandtestingPage.oneTimePasswordButtons.click();
        ReusableMethods.bekle(2);


        ForgotpasswordPages forgotpasswordPages = new ForgotpasswordPages() ;
        ReusableMethods.scrollToElement(forgotpasswordPages.emailBox);
        forgotpasswordPages.emailBox.sendKeys("practice@expandtesting.com");
        forgotpasswordPages.sendCodeButtons.click();
        System.out.println(forgotpasswordPages.flashMessageText.getText());
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.flashMessageText,"dogru giriş mesaajı");

        forgotpasswordPages.CorrectionCodeBox.sendKeys("214365");
        forgotpasswordPages.verifiyingButtons.click();

        System.out.println(forgotpasswordPages.flashVerifiyingMessage.getText());
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.flashVerifiyingMessage,"code dogrulama yazisi");

        forgotpasswordPages.LogOutButtons.isDisplayed();
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.LogOutButtons,"giriş başarılı değil");



    }
}
