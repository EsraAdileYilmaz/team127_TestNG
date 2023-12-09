package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolPage {


    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //bu kodla driver'imizi bu class'ta tanitmis olduk
    }


    @FindBy(xpath = "//button[text()='Accept']")
    public WebElement cookies;

    @FindBy(xpath = "//*[@*='user-menu-icon']")
    public WebElement accountIcon;

    @FindBy(xpath = "//*[@id='register-email-input']")
    public WebElement registerEmailBox;

    @FindBy(xpath = "//*[@id='register-password-input']")
    public WebElement registerPasswordBox;

    @FindBy (xpath = "//*[@data-testid='toggle-button-0']")
    public WebElement genderWomenButton;

    @FindBy(xpath = "//*[@data-testid='register-button']")
    public WebElement signupButonu;

}
