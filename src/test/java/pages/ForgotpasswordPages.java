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

    @FindBy(xpath = "//*[@id=\"btn-send-otp\"]")
    public WebElement sendCodeButtons ;

    @FindBy(xpath = "//*[@id=\"otp-message\"]")
    public WebElement flashMessageText ;

    @FindBy(xpath = "//*[@id=\"otp\"]")
    public WebElement CorrectionCodeBox ;

    @FindBy(xpath = "//*[@id=\"btn-send-verify\"]")
    public WebElement verifiyingButtons ;

    @FindBy(xpath = "//*[@id=\"flash\"]")
    public WebElement flashVerifiyingMessage ;

    @FindBy(xpath = "//*[@id=\"core\"]/div/div/a/i")
    public WebElement LogOutButtons ;







}
