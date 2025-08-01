package tests.PracticeExpandtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C19_BrowserInformationTest {

    @Test
    public void browserInformationTesti(){

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1200)");

        ReusableMethods.bekle(2);

        practiceexpandtestingPage.browserInformationButtons.click();

        practiceexpandtestingPage.showBrowserInformationButtons.click();

        ReusableMethods.bekle(2);
    Driver.quitDriver();
    }
}
