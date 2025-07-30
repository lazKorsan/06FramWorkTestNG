package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestloginPage {

    public TestloginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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




}
