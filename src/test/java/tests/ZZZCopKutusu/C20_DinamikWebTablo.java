package tests.ZZZCopKutusu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C20_DinamikWebTablo {



    @Test
    public void dinamikxpathKullanimi() {

        Driver.getDriver().get(ConfigReader.getProperty("dinamikXpathUrl"));

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage();
        practiceexpandtestingPage.showBrowserInformationButtons.click();

        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//*[@id=\"browser-info\"]/table/tbody/tr"));
        for (WebElement row : rows) {
            // Her satırdaki sütunları al (td öğeleri)
            List<WebElement> cells = row.findElements(By.xpath(".//td"));

            if (cells.size() >= 2) {
                String propertyName = cells.get(0).getText();  // Özellik adı (örn: "User Agent")
                String propertyValue = cells.get(1).getText(); // Değer (örn: "Mozilla/5.0...")

                // Özelliğe göre assertion
                switch (propertyName) {
                    case "User Agent":
                        Assert.assertTrue(propertyValue.contains("Chrome"));
                        break;
                    case "Platform":
                        Assert.assertEquals(propertyValue, "Win32");
                        break;
                    // Diğer özellikler...
                }
            }


            // Driver.quitDriver();
        }
    }

    @Test
    public void webtablosuMapeAktarma (){

        Driver.getDriver().get(ConfigReader.getProperty("dinamikXpathUrl"));

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage();
        practiceexpandtestingPage.showBrowserInformationButtons.click();

        Map<String, String> tableData = new HashMap<>();
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//*[@id=\"browser-info\"]/table/tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            if (cells.size() >= 2) {
                tableData.put(cells.get(0).getText(), cells.get(1).getText());
            }
        }

// Assertion'ları Map üzerinden yap
        Assert.assertTrue(tableData.get("User Agent").contains("Chrome"));
        Assert.assertEquals(tableData.get("Platform"), "Win32");

    }



    @Test
    public void dataProviderlaWebtabloTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("dinamikXpathUrl"));

        PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage();
        practiceexpandtestingPage.showBrowserInformationButtons.click();





        //@DataProvider(name = "browserData")
        //    public Object[][] getBrowserData() {
        //        return new Object[][] {
        //            {"User Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36... Chrome"},
        //            {"Platform", "Win32"},
        //            // Diğer satırlar...
        //        };
        //    }
        //
        //    @Test(dataProvider = "browserData")
        //    public void testBrowserProperties(String property, String value) {
        //        System.out.println(property + " : " + value);
        //    }
        //}


    }





}
