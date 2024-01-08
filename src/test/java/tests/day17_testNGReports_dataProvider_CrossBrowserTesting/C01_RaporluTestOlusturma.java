package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){
        extentTest=extentReports.createTest("Arama testi","Kullanici belirlenen kelimeyi aratip, dogru arama yapildigini test eder");

     //testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu ana sayfaya gider");

     // belirlenen arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("Belirlenen arama kelimesi icin arama yapar");

     //arama sonucunda urun bulunabildigini test edin
        int aramaSonucSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        assertTrue(aramaSonucSayisi > 0);
        extentTest.pass("Arama sonucunda urun bulunabildigini test eder");


     //ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urunu tiklar");

     //acilan urun sayfasinda urun isminin case sensitive olmadan belirlenen arama kelimesini icerdigini test edin
        String actualUrunIsmiKucukHarf=testOtomasyonuPage
                                       .urunSayfasindakiIlkUrunIsimElementi
                                       .getText()
                                       .toLowerCase();
        assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));
        extentTest.pass("Acilan urun sayfasinda urun isminin case sensitive olmadan belirlenen arama kelimesini icerdigini test eder");




        extentTest.info("Sayfayi kapatir");

    }
}
