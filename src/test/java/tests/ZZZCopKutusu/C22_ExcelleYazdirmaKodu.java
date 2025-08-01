package tests.ZZZCopKutusu;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class C22_ExcelleYazdirmaKodu {


    public static void writeToExcel(List<Map<String, String>> data, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Browser Properties");

        // Başlık satırı
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Property");
        headerRow.createCell(1).setCellValue("Value");

        // Veri satırları
        int rowNum = 1;
        for (Map<String, String> row : data) {
            Row dataRow = sheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(row.get("Property"));
            dataRow.createCell(1).setCellValue(row.get("Value"));
        }

        // Dosyaya yaz
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
    }

    // Kullanımı:
   // writeToExcel(getTableData(), "browser_properties.xlsx");
}
