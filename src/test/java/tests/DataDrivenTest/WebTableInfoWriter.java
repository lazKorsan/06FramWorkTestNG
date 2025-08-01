package tests.DataDrivenTest;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PracticeexpandtestingPage;
import utilities.Driver;
import utilities.ConfigReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WebTableInfoWriter {

    public static void main(String[] args) throws IOException {
        // Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("dinamikXpathUrl"));

        pages.PracticeexpandtestingPage practiceexpandtestingPage = new pages.PracticeexpandtestingPage() ;



        // Sayfadaki butona tıkla
       //PracticeexpandtestingPage practiceexpandtestingPage = new PracticeexpandtestingPage();
        practiceexpandtestingPage.showBrowserInformationButtons.click();

        // Excel dosyası oluştur
        String excelPath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\PracticeExpandtesting\\webtablo.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Browser Info");

        // Başlık satırı
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Bilgi Türü");
        header.createCell(1).setCellValue("Değer");

        // Bilgileri DOM'dan al
        List<WebElement> rows = practiceexpandtestingPage.browserInfoItems; // Tablo satırlarını al
        int rowIndex = 1;

        // Tablo satırlarını döngüyle işle
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td")); // Hücreleri bul
            if (cells.size() >= 2) { // En az 2 hücre olduğundan emin ol
                Row excelRow = sheet.createRow(rowIndex++);
                excelRow.createCell(0).setCellValue(cells.get(0).getText()); // Bilgi Türü
                excelRow.createCell(1).setCellValue(cells.get(1).getText()); // Değer
            }
        }

        // Excel dosyasını kaydet
        try (FileOutputStream fileOut = new FileOutputStream(excelPath)) {
            workbook.write(fileOut);
            System.out.println("Bilgiler Excel dosyasına başarıyla yazıldı: " + excelPath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }

        practiceexpandtestingPage.hideBrowserInformationButton.click();

        // Driver kapat

    }
}