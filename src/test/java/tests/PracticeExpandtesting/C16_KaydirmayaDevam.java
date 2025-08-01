package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C16_KaydirmayaDevam {
    @Test
    public void kaydirmayaDevam(){
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

        new C15_ScrollBuilderTamKalip(practiceexpandtestingPage.oneTimePasswordButtons)
                .withOffset(100)              // 100 piksel ofset
                .withSpeed(200)               // 500 ms hız (şu an kullanılmıyor)
                .withRetry(3)                 // 3 kez tekrar deneme
                .withScreenshotOnFail()       // Hata durumunda ekran görüntüsü al
                .execute();
    }
}
