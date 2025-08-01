package tests.PracticeExpandtesting2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;



public class C22_dragAndDropButtonsTesti extends TestBaseRapor {

    @Test
    public void dragAndDropButtons() {

        extentTest = extentReports.createTest("Raporlu Test",
                "Kullanici test sayfasındaki kutuları surukleyebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        extentTest.info("kullanıcı ana sayfaya gider");

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage();
        extentTest.info("kullanıcı homepage uzerinden POM oluşturur");

        ReusableMethods.bekle(3);
        extentTest.info("kullanıcı sayfanın yuklenmesini bekler");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,900)");
        extentTest.info("kullanıcı ddragandDropb butonu görunceye kadar scroll işlemi yapar");

        ReusableMethods.bekle(2);
        extentTest.info("reklamlardan dolayı sayfayı 3 saniye bekletir ");

        practiceexpandtestingPage.dragAndDropButtons.click();
        extentTest.info("dragAndDropsButtonuna basar");

        Actions actions = new Actions(Driver.getDriver());
        extentTest.info("kullanıcı actions objesi oluşturur");
        actions.dragAndDrop(practiceexpandtestingPage.aKutusu, practiceexpandtestingPage.bKutusu).perform();
        extentTest.info("kullanıcı dragAndDrop özelliğini kullanarak A'kutusunu B'kutusunun üzerine taşır");

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.aKutusu, "dragdropsAkutusu");
        extentTest.info("kullanıcı drapdrop sonrası Akutusunun fotoğrafını çeker");
        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.bKutusu, "Bkutusunun fotografını çeker");
        extentTest.info("B kutusunun fotografını çeker") ;


        String textA = practiceexpandtestingPage.aKutusu.getText();
        String textB = practiceexpandtestingPage.bKutusu.getText();
        extentTest.info("kullanıcı kaydırma işlemi sonrası A kutusu ve b kutusu yazılarını kaydeder");

        Assert.assertEquals(textA, "B");
        extentTest.pass("locatırı ilk hali le A kutusuna ait olan kutuda B yazdığını doğrular");

        Assert.assertEquals(textB, "A");
        extentTest.pass("locatırı ilk hali le B kutusuna ait olan kutuda A yazdığını doğrular");

        Driver.quitDriver();

    }
}


















