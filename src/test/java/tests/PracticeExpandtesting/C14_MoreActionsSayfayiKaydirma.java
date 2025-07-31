package tests.PracticeExpandtesting;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C14_MoreActionsSayfayiKaydirma {

    @Test
    public void actionsTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;
        //Actions actions = new Actions(Driver.getDriver());
       // actions.moveToElement(practiceexpandtestingPage.oneTimePasswordButtons).perform();

        //<-- scrollToElement Methodunun Çagırılması -->
       // ReusableMethods.scrollToElement(practiceexpandtestingPage.oneTimePasswordButtons);
        // <-- ==================================== -->
        //<-- scrollToElementWithWait Methodunun Cagırılması -->
       // ReusableMethods.scrollToElementWithWait(practiceexpandtestingPage.oneTimePasswordButtons,300);
        // <-- =================================== -->
        // <-- scrollBottom methodunun Cagırılması -->
        //ReusableMethods.scrollToBottom();
        // <-- =================================== -->

        //<-- ===================Advanced Kaydırma Özelliği -->
        // Çoklu ayar örneği
        ReusableMethods.scrollToElement(practiceexpandtestingPage.oneTimePasswordButtons)
                .withSpeed(300)
                .withRetry(3) // 3 deneme
                .withScreenshotOnFail() // Hata durumunda screenshot
                .execute();


    }
}
