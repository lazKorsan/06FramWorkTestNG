package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OnetimepasswordPage {

    public OnetimepasswordPage (){
        PageFactory.initElements(Driver.getDriver(),this);

    }

   // @FindBy(xpath = "//*[@id=\"examples\"]/div[2]/div[1]/div/div[1]/h3/a")
  //  public WebElement oneTimePasswordButtons ;

}
