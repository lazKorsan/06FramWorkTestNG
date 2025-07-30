package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_screenShotKontrol {

    @Test
            public void screenShotCheck(){

    Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
    PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

    ReusableMethods.takeFullPageScreenshot("paAnasayfaUrl");

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.testCasesButton,"testcaseButton");

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.ApiTestingButtons,"apitesting");

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.XpathTestButtons,"xpathtestleri");

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.searchBox,"searchbox");








}
}
