package tests.PracticeExpandtesting;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;

public class C13_FareHareketiIleSayfayiAsagiKaydirma {

    @Test
    public void actionsSinifiIleSayfaKaydirmaTesti() throws AWTException {
        Driver.getDriver().get(ConfigReader.getProperty("paAnasayfaUrl"));

        Robot robot = new Robot();
        robot.mouseWheel(10); // 5 tıklama aşağı kaydırır







    }
}
