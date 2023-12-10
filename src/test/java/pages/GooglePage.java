package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage{

    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //bu kodla driver'imizi bu class'ta tanitmis olduk
    }

    @FindBy(xpath = "//div[text()='Tout accepter']")
    public WebElement cookies;

    @FindBy(id="APjFqb")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@id='result-stats']")
    public WebElement sonucYaziElementi;










}
