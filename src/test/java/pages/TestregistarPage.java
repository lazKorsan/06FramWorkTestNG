package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestregistarPage {

    public  TestregistarPage (){

        PageFactory.initElements(Driver.getDriver(), this) ;
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement usernameBox ;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox ;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    public WebElement confirmPasswordBox ;

    @FindBy(xpath = "//*[@id=\"register\"]/button")
    public WebElement registerButtons ;

    @FindBy(xpath = "//*[@id=\"flash\"]/b")
    public WebElement flashTextRegister ;

}
