package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZerowebappPage {

    public ZerowebappPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInLinki;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBankingLinki;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLinki;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement pcCurrencyDropdownElementi;


}
