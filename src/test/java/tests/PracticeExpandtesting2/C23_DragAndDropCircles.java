package tests.PracticeExpandtesting2;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.PracticeexpandtestingPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;

public class C23_DragAndDropCircles extends TestBaseRapor {

    @Test
    public void dragAndDropCircles () throws AWTException {

        extentTest = extentReports.
                createTest("Raporlu Test",
                "Kullanici test sayfasındaki daireleri Kare üzerine  surukleyebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("drapAndDropsCirclesTestUrl"));
        extentTest.info("kullanıcı Drag and Drop Circles sayfasına gider");

       // Robot robot = new Robot();
       // robot.mouseWheel(10);

        PracticeexpandtestingPage practiceexpandtestingPage =new PracticeexpandtestingPage() ;
        extentTest.info("POM objesini oluşturur") ;

        Actions actions = new Actions(Driver.getDriver());
        extentTest.pass("adamaım yeni actionlara yelken açar") ;


        actions.dragAndDrop(practiceexpandtestingPage.draggableRedCircle, practiceexpandtestingPage.targetBox).perform();


        actions.dragAndDrop(practiceexpandtestingPage.draggableGreenCircle,practiceexpandtestingPage.targetBox).perform();


        actions.dragAndDrop(practiceexpandtestingPage.draggableBlueCircle,practiceexpandtestingPage.targetBox).perform();
        extentTest.info("kullanıcı renkli daireleri griKutuyaTaşır");

        ReusableMethods.bekle(10);
        extentTest.info("Kullanıcı taşıma işlemi sonrası  ne olduğunu görmek için sayfayı 2 saniye açık tutar") ;

        ReusableMethods.getWebElementScreenshot(practiceexpandtestingPage.targetBox,"hedef ktu");
        extentTest.pass("kullanıcı taşıma işlemleri sonrası fotograf çeker");

    }
}
