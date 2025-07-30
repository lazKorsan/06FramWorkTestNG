package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.WebinputsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C05_raporluTest extends TestBaseRapor {

    @Test
    public void RaporluTest(){


        extentTest = extentReports.createTest("Raporlu Test",
                "Kullanici test sayfasındaki kutulara istenen kelimleri girebilmeli");


        WebinputsPage webinputsPages = new WebinputsPage() ;


        Driver.getDriver().get(ConfigReader.getProperty("peTestToolsUrl"));
        extentTest.info("kullanıcı webınpıt sayfasına gider");

        webinputsPages.WebInputButton.click();
        extentTest.info("kullanıcı webınputs butonuna tıklar");

        webinputsPages.InputNumberBox.sendKeys("12345");
        extentTest.info("kullanıcı numara girişini sağlar");

        webinputsPages.InputTextBox.sendKeys("helloworld");
        extentTest.info("text kutusuna istenen kelimeyi girer");

        webinputsPages.InputPasswordBox.sendKeys("raporlutest");
        extentTest.info("kullanıcı password kutusuna rapoelutrest kelimesini girer");

        webinputsPages.InputDateBox.sendKeys("27.07.2025");
        extentTest.info("tarih kutusuna gunun tarihini girer");

        webinputsPages.DisplayInputsButtons.click();
        extentTest.info("girdiği kelimelrin görülmesi için display butonuna basar");

        webinputsPages.ClearInPutsButtons.click();
        extentTest.info("girdiğii kelimleri siler ");





        Driver.quitDriver();
        extentTest.info("kullanıcı sayfayı kapatır ") ;

    }
}
