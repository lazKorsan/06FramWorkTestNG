package tests.PracticeExpandtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C12_SayfaKaydirmaTesti {

    @Test
    public void onetimepasswordTest() {

        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,800)"); // 500 piksel aşağı kaydır







    }
}
