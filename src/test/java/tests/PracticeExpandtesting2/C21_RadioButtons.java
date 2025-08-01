package tests.PracticeExpandtesting2;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.GelismisEkranKaydirmaMethodu;
import utilities.ReusableMethods;

public class C21_RadioButtons {

    @Test
    public void radioButtons(){
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

        ReusableMethods.bekle(3);



        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,900)");
        ReusableMethods.bekle(2);
        //new GelismisEkranKaydirmaMethodu(practiceexpandtestingPage.radioButtonsTestPageButtons)
        //                .withOffset(100)
        //                .withSpeed(700)
        //                .withRetry(8)
        //                .withScreenshotOnFail()
        //                .execute();

       // ReusableMethods.getWebElementScreenshot(PracticeexpandtestingPage.radioButtonsTestPageButtons,"radiobuttuonları");
        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.radioButtonsTestPageButtons,"radiobuttonsusus");

        practiceexpandtestingPage.radioButtonsTestPageButtons.click();

        ReusableMethods.bekle(2);


        ReusableMethods.scrollToElement(practiceexpandtestingPage.tennisRadioButtons);

        practiceexpandtestingPage.blackRadioButtons.click();
        practiceexpandtestingPage.footballRadioButtons.click();

    }
}
