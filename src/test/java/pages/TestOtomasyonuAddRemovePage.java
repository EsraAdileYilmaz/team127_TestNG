package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuAddRemovePage {

    public TestOtomasyonuAddRemovePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='sub-btn']")
    public WebElement addButonu;

    @FindBy(xpath = "//button[@class='remove-btn']")
    public WebElement removeButonu;

    @FindBy(xpath = "//*[text()='Add/Remove Elements']")
    public WebElement addRemoveYazisiLinki;
}
