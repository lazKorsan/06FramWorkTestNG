package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.WebinputsPage;
import utilities.*;

public class C04_WebInputsTesti {

    @Test

    public void webInputsTesti(){
        WebinputsPage webinputsPages = new WebinputsPage() ;

        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        //extentTest.info("Kullanici pendingexpeand anasayfaya gider");


       webinputsPages.WebInputButton.click();
       //extentTest.info("web ınputButtonuna baar");
       ReusableMethods.bekle(4);

       webinputsPages.InputNumberBox.sendKeys("12345");
       //extentTest.info("number box a belirlenen sayıları girer");

       webinputsPages.InputTextBox.sendKeys("helloworld");
       //extentTest.info("testbox kutusuna istenen cumleyi yazar");

       webinputsPages.InputPasswordBox.sendKeys("henuzbilinmiyor");
       //extentTest.info("password kutusuna belirlenen şifreyi girer");

       webinputsPages.InputDateBox.sendKeys("26.07.2025");
       //extentTest.info("gun ay ve tarih girer");

       webinputsPages.DisplayInputsButtons.click();
      // extentTest.info("display butonuna basarak girilenleri doğrular");

       webinputsPages.ClearInPutsButtons.click();
       //extentTest.info("clearbutonuna basarak görünmez yapar");
       ReusableMethods.bekle(3);
       //extentTest.info("sayfayı 3 saniye bekletir");

       Driver.quitDriver();
      // extentTest.info("sayfayı kapatır ");

    }


}
