package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EasybusticketPage {

    public EasybusticketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Allow']")
    public WebElement cookies;

    @FindBy(xpath = "//*[@class='sign-up']")
    public WebElement signUpLink;

    @FindBy(xpath = "//span[text()='Sign Up your Account']")
    public WebElement textOfSignUpyourAccount;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement textBoxOfFirstName;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement buttonOfAcceptingall;

    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement buttonOfSignUp;

    @FindBy(xpath = "//*[@class='iziToast-wrapper iziToast-wrapper-topRight']")
    public WebElement alert;

}
