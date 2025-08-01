package tests.PracticeExpandtesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotpasswordPages;
import pages.PracticeexpandtestingPage;
import utilities.*;


public class C18_RaporluDogrulamaKoduTesti extends TestBaseRapor {
    @Test
    public void test01(){

        extentTest = extentReports.createTest("Raporlu Test",
                "Kullanici dogrulama kodu ile hesabına giriş yapabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        extentTest.info("kullanıcı test sayfasını açar");
        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

        new GelismisEkranKaydirmaMethodu(practiceexpandtestingPage.oneTimePasswordButtons)
                .withOffset(100)
                .withSpeed(300)
                .withRetry(3)
                .withScreenshotOnFail()
                .execute();
        extentTest.info("dogrulama kodu butonunun görünürlüğünü sağlar");
        practiceexpandtestingPage.oneTimePasswordButtons.click();
        extentTest.info("dogrulama kodu butonuna basar");
        ReusableMethods.bekle(2);
        extentTest.info("reklamın kapanmasını bekler ") ;


        ForgotpasswordPages forgotpasswordPages = new ForgotpasswordPages() ;
        ReusableMethods.scrollToElement(forgotpasswordPages.emailBox);
        extentTest.info("email kutusunun görünürlüğünü sağlar");
        forgotpasswordPages.emailBox.sendKeys("practice@expandtesting.com");
        extentTest.info("email kutusuna geçerli email adresini girer");
        forgotpasswordPages.sendCodeButtons.click();
        extentTest.info("kod isteme butununa basar");
        System.out.println(forgotpasswordPages.flashMessageText.getText());
        extentTest.info("flash textin yazısını konsala yazdırır") ;
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.flashMessageText,"dogru giriş mesaajı");
        extentTest.info("flash mesajın resmini çeker ");

        forgotpasswordPages.CorrectionCodeBox.sendKeys("214365");
        extentTest.info("varsayılan doğrulama kodunu girer");
        forgotpasswordPages.verifiyingButtons.click();
        extentTest.info("kod doğrulama butununa basar") ;

        System.out.println(forgotpasswordPages.flashVerifiyingMessage.getText());
        extentTest.info("dogrulama flash yazısını konsala yazdırır") ;
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.flashVerifiyingMessage,"code dogrulama yazisi");
        extentTest.info("dogrulama flash yazısının resmini çeker ") ;

        forgotpasswordPages.LogOutButtons.isDisplayed();
        extentTest.info("Logout butonunun görünürlüğünü test eder") ;
        ReusableMethods.getWebElementScreenshot(forgotpasswordPages.LogOutButtons,"giriş başarılı ");
        extentTest.info("LogoutButonun resmini çeker ") ;

        Driver.quitDriver();
        extentTest.info("sayfayı kapatır") ;



    }
}
