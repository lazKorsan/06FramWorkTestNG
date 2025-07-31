package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ForgotpasswordPages {

    public ForgotpasswordPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement emailBox ;

    @FindBy(xpath = "//*[@id=\"forgot_password\"]/button")
    public WebElement retrievePasswordButton ;

    @FindBy(xpath = "//*[@id=\"confirmation-alert\"]")
    public WebElement flashText ;




}
