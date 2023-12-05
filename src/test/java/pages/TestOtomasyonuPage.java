package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    /*
        TestNG'de locate etmek icin;
        @FindBy( "locate sekli") notasyonu ve
        public WebElement isim;  kullanilir.
        public List<WebElement> isim; kullanilir

        initElements(); elementlere ilk deger atamasini yap

     */
    public TestOtomasyonuPage(){//bu class'tan gorunur constructor olusturduk.
        PageFactory.initElements(Driver.getDriver(),this);
        //bu kodla sunu demis olduk.driver'imiz bu class'ta tanimli olsun.
    }




    @FindBy(id="global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//div[@class='product-box my-2  py-1']")
    public List<WebElement> bulunanUrunElementleriList;

}
