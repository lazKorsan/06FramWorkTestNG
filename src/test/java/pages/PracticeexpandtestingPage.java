package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PracticeexpandtestingPage {

    /// ////////////////////////////////////////////
    //<===========olmazsaOlmaz====================>
public PracticeexpandtestingPage(){
    PageFactory.initElements(Driver.getDriver(),this);
    //<============10 ve 11 satırlar constactırı görünür yapar=========>
}

    @FindBy(xpath = "//*[@id=\"home-header\"]/div[1]/div/div/a[1]")
    public WebElement testCasesButton ;

    @FindBy(xpath = "//*[@id=\"home-header\"]/div[1]/div/div/a[2]")
    public WebElement ApiTestingButtons ;

    @FindBy(xpath = "//*[@id=\"home-header\"]/div[1]/div/div/a[3]")
    public WebElement XpathTestButtons ;

    @FindBy(xpath = "//input[@id=\"search-input\"]")
    public WebElement searchBox ;








}
