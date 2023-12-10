package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@class='panel-title']")
    public List<WebElement> categoryElementleriListi;

    @FindBy(tagName = "a")
    public List<WebElement> linkElementleriListi;

    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement productsLinki;

    @FindBy(xpath = "//*[@id='sale_image']")
    public WebElement specialOfferYazisi;











}
