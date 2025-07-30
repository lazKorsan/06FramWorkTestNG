package tests.PracticeExpandtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestregistarPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class C09_DataProviderRegister extends TestBaseRapor {


    @DataProvider(name = "kullaniciVerileri")
    public Object[][] kullaniciData() {
        return new Object[][] {
                // {ad, email, şifre}
                {"Ahmet Yılmaz", "Ahmet123", "Ahmet123"},   // 1. veri seti
                {"Ayşe Demir", "Ayse.456", "Ayse.456"},      // 2. veri seti
                {"Mehmet Kaya", "Mk789!", "Mk789!"}      // 3. veri seti
        };
    }

    @Test(dataProvider = "kullaniciVerileri")
    public void cokluLoginTesti(String ad, String email, String sifre){

        extentTest = extentReports.createTest("Raporlu Test",
                "Kullanici test sayfasındaki kutulara istenen kelimleri girebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("registerpageUrl"));
        extentTest.info("kullanıcı register sayfasına gider");
        TestregistarPage testregistarPage = new TestregistarPage();

        testregistarPage.usernameBox.sendKeys(ad);
        extentTest.info("kullanıcı ad kutusuna verilen ismi girer");
        testregistarPage.passwordBox.sendKeys(sifre);
        extentTest.info("kullanıcı paswword kutusuna verilen şifreyi girer");
        testregistarPage.confirmPasswordBox.sendKeys(sifre);
        extentTest.info("kullanıcı paswordu doğrular") ;
        testregistarPage.registerButtons.click();
        extentTest.info("kuulanıcı register butonuna basar") ;

        testregistarPage.flashTextRegister.getText() ;
        extentTest.info("kullanıcı flash text yazısını konsola yazdırır");
        ReusableMethods.getWebElementScreenshot(testregistarPage.flashTextRegister,"flash text");
        extentTest.info("kullanıcı flash test yazısının resmini çeker  ");

        ReusableMethods.bekle(3);
        extentTest.info("sahneyi 3 saniye bekletir") ;
        Driver.quitDriver();
        extentTest.info("tarayıcıyı ");
    }








    }

