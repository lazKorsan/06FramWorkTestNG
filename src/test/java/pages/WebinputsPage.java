package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebinputsPage {

    public WebinputsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='my-link']")
    public WebElement WebInputButton;

    @FindBy(xpath = "//*[@id=\"input-number\"]")
    public WebElement InputNumberBox ;

    @FindBy(xpath = "//*[@id=\"input-text\"]")
    public WebElement InputTextBox ;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    public WebElement InputPasswordBox ;

    @FindBy(xpath = "//*[@id=\"input-date\"]")
    public WebElement InputDateBox ;

    @FindBy(xpath = "//*[@id=\"btn-display-inputs\"]")
    public WebElement DisplayInputsButtons ;

    @FindBy(xpath = "//*[@id=\"btn-clear-inputs\"]")
    public WebElement ClearInPutsButtons ;


}
