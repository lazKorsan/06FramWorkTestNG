package tests.ZZZCopKutusu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class C21_DataProviderWebTablo {
    @DataProvider(name = "browserData")
    public Object[][] getBrowserData() {
        return new Object[][] {
                {"User Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36... Chrome"},
                {"Platform", "Win32"},
                // Diğer satırlar...
        };
    }

    @Test(dataProvider = "browserData")
    public void testBrowserProperties(String property, String value) {
        System.out.println(property + " : " + value);
    }
    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> tableData = new ArrayList<>();
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//*[@id=\"browser-info\"]/table/tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            if (cells.size() >= 2) {
                Map<String, String> rowData = new HashMap<>();
                rowData.put("Property", cells.get(0).getText());
                rowData.put("Value", cells.get(1).getText());
                tableData.add(rowData);
            }
        }
        return tableData;
    }


    public void writeToTxt(List<Map<String, String>> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map<String, String> row : data) {
                writer.write(row.get("Property") + " | " + row.get("Value") + "\n");
            }
        }
    }

    // Kullanımı:
    //writeToTxt(getTableData(), "browser_properties.txt");
}


