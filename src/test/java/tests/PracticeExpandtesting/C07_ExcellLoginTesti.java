package tests.PracticeExpandtesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C07_ExcellLoginTesti {
    private WebDriver driver;

    static final String EXCEL_YOLU = "C:\\Users\\Hp\\OneDrive\\Desktop\\PracticeExpandtesting\\logintest.xlsx";
    private static final String SCREENSHOT_FOLDER = "C:\\Users\\Hp\\OneDrive\\Desktop\\PracticeExpandtesting\\";

    @FindBy(xpath = "//*[@id=\"examples\"]/div[1]/div[2]/div/div[1]/h3/a")
    public WebElement TestLoginPagesButtons ;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement userNameBox ;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passWordBox ;

    @FindBy(xpath = "//*[@id=\"login\"]/button")
    public WebElement loginButtons ;

    @FindBy(xpath = "//*[@id=\"flash\"]")
    public WebElement flashText ;

    @FindBy(xpath = "//*[@id=\"core\"]/div/div/a")
    public WebElement logOutButtons ;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver(); // Her test öncesi yeni bir driver başlat
        PageFactory.initElements(driver, this);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            Driver.closeDriver(); // Her test sonunda driver'ı kapat
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_YOLU);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");

        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][2];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);

            // EMAIL (String olarak oku)
            Cell emailCell = row.getCell(0);
            String email = emailCell.getCellType() == CellType.NUMERIC
                    ? String.valueOf((int) emailCell.getNumericCellValue())
                    : emailCell.getStringCellValue();

            // PASSWORD (String olarak oku)
            Cell passwordCell = row.getCell(1);
            String password = passwordCell.getCellType() == CellType.NUMERIC
                    ? String.valueOf((int) passwordCell.getNumericCellValue())
                    : passwordCell.getStringCellValue();

            data[i - 1][0] = email;
            data[i - 1][1] = password;
        }

        workbook.close();
        fis.close();

        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLoginWithExcelData(String email, String password) throws IOException {
        driver.get("https://practice.expandtesting.com/login");
        ReusableMethods.bekle(5);

        userNameBox.sendKeys(email);
        ReusableMethods.bekle(2);
        passWordBox.sendKeys(password);
        ReusableMethods.bekle(2);
        loginButtons.click();


        boolean loginSuccess = isLogoutButtonVisible();

        // Excel'e sonuçları yaz
        updateExcelResult(email, password, loginSuccess);

        if (!loginSuccess) {
            takeScreenshot(email);
        }

        // Çıkış yap (eğer başarılıysa)
        if (loginSuccess) {
            logOutButtons.click();
            ReusableMethods.bekle(2);
        }
    }

    private boolean isLogoutButtonVisible() {
        try {
            return logOutButtons.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void updateExcelResult(String email, String password, boolean success) throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_YOLU);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");

        // Hücre stilleri oluştur
        CellStyle successStyle = workbook.createCellStyle();
        successStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        successStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle failStyle = workbook.createCellStyle();
        failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Tüm satırları kontrol et
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).getStringCellValue().equals(email) &&
                    row.getCell(1).getStringCellValue().equals(password)) {

                // Hücreleri renklendir
                row.getCell(0).setCellStyle(success ? successStyle : failStyle);
                row.getCell(1).setCellStyle(success ? successStyle : failStyle);
                break;
            }
        }

        FileOutputStream fos = new FileOutputStream(EXCEL_YOLU);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    private void takeScreenshot(String email) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "login_fail_" + email + "_" + timestamp + ".png";
        File destFile = new File(SCREENSHOT_FOLDER + fileName);

        Files.copy(screenshot.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}