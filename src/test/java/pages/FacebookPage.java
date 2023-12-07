package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    //1.adim driver'imizi bu sayfaya tanitmamiz lazim.bunun icin constructor'imizi gorunur hale getirmemiz lazim.
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //bu kodla driver'imizi bu class'ta tanitmis olduk
    }

    @FindBy(xpath = "//button[@title='Autoriser tous les cookies']")
    public WebElement cookies;

    @FindBy(id="email")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement seconnecterButton;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement message;








}
