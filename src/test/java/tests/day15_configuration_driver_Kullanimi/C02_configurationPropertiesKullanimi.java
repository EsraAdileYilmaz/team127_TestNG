package tests.day15_configuration_driver_Kullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_configurationPropertiesKullanimi {


    @Test
    public void aramaTesti(){

        // test otomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        // configuration.properties'de belirlenmis olan aranacak urunu aratin
        //1.Adim locate'leri almak icin locate'lerin bulundugu class'tan obje olustur
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.
                sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);


        // arama sonucunda urun bulunabildigini test edin
        int bulunanUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanUrunSayisi > 0);


        // ilk urune tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();//0. index=1.urun


        // acilan sayfada urun isminin case sensitive olmadan
        // configuration.properties'de belirlenmis olan aranacak kelimeyi icerdigini test edin
        String actualUrunIsmiKucukHarf=testOtomasyonuPage
                                       .urunSayfasindakiIlkUrunIsimElementi
                                       .getText()
                                       .toLowerCase();
        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        ReusableMethods.bekle(1);

        Driver.quitDriver();

    }
}
