package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.BulXpath;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_LocateKontrol {

    @Test
    public void locateKontrol(){
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));
        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage() ;
        System.out.println("testCasesButton");
        BulXpath.printXpathFormulas(practiceexpandtestingPage.testCasesButton);

        System.out.println("ApiTestingButtons");
        BulXpath.printXpathFormulas(practiceexpandtestingPage.ApiTestingButtons);

        System.out.println("XpathTestButtons");
        BulXpath.printXpathFormulas(practiceexpandtestingPage.XpathTestButtons);

        System.out.println("searchBox");
        BulXpath.printXpathFormulas(practiceexpandtestingPage.searchBox);







    }
}
