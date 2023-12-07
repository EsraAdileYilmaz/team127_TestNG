package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    /*
        TestNG framework'unde pages packages'i alinan locate'leri icerir.


        TestNG'de locate etmek icin;
        @FindBy( "locate sekli") notasyonu ve
        public WebElement isim;  kullanilir.
        public List<WebElement> isim; kullanilir

        initElements(); elementlere ilk deger atamasini yap
     */

    //1.adim driver'imizi bu sayfaya tanitmamiz lazim.bunun icin constructor'imizi gorunur hale getirmemiz lazim.
    public TestOtomasyonuPage(){//bu class'tan gorunur constructor olusturduk.
        PageFactory.initElements(Driver.getDriver(),this);
        //bu kodla sunu demis olduk.driver'imiz bu class'ta tanimli olsun.
    }


    @FindBy(id="global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//div[@class='product-box my-2  py-1']")
    public List<WebElement> bulunanUrunElementleriList;//phone yazinca gelen urun listesi


    @FindBy(xpath ="//div[@class=' heading-sm mb-4']" )
    public WebElement urunSayfasindakiIlkUrunIsimElementi;

    @FindBy(xpath = "(//span[@class='menu-icon-text'])[1]")
    public WebElement accountButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordKutusu;

    @FindBy(id="submitlogin")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutButonu;

}
