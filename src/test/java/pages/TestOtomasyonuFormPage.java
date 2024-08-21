package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuFormPage {


    //1.adim driver'imizi bu sayfaya tanitmamiz lazim.bunun icin constructor'imizi gorunur hale getirmemiz lazim.
    public TestOtomasyonuFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);//bu sayfada driver'i tanimla
        //bu kodla driver'imizi bu class'ta tanitmis olduk
    }

    @FindBy(xpath = "//select[@class='form-control']")
    public List<WebElement> dropdownMenuElementleriList;//bu locate'le gun,ay,yil elementlerini bu list'e atadik.
    //0.indexte gun, 1.indexte ay, 2.indexte yil elementi vardir

    @FindBy(id = "gridCheck4")
    public WebElement carpintiCheckboxKutusu;

    @FindBy(id = "gridCheck5")
    public WebElement sirtAgrisiCheckboxKutusu;

    @FindBy(id = "hastalikCheck2")
    public WebElement sekerCheckboxKutusu;

    @FindBy(id = "hastalikCheck7")
    public WebElement epilepsiCheckboxKutusu;


}
