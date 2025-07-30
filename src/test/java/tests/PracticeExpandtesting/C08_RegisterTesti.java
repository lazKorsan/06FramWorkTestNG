package tests.PracticeExpandtesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestregistarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C08_RegisterTesti {
    // bu testin failed olması isteniyor.
    @Test
    public void registerTesti(){
        TestregistarPage testregistarPage = new TestregistarPage() ;

        Driver.getDriver().get(ConfigReader.getProperty("registerpageUrl"));

        testregistarPage.usernameBox.sendKeys("practice");
        testregistarPage.passwordBox.sendKeys("SuperSecretPassword!");
        testregistarPage.confirmPasswordBox.sendKeys("SuperSecretPassword!");
        testregistarPage.registerButtons.click();

        testregistarPage.flashTextRegister.getText() ;
        String expectedFlashRegisterBoxYazisi = "Username is already taken.";
        String actualFlashRegisterBoxYazisi = testregistarPage.flashTextRegister.getText() ;

       Assert.assertNotEquals(actualFlashRegisterBoxYazisi,expectedFlashRegisterBoxYazisi,"kullanıcı adı daha önce alınmış");





    Driver.quitDriver();
    }
}
