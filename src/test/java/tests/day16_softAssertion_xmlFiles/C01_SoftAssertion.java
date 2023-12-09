package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class C01_SoftAssertion {


    @Test
    public void softAssertionTesti(){

         /*
            TestNG coklu assertion iceren testlerde
            2 alternatif sunuyor:

            1-) JUnit'deki method'larin aynilarini kullanabilirsiniz.
               Ancak Testimiz FAILED olan ilk assertion'da calismayi durdurur,
               geriye kalan assertion'larin PASSED olup olmadigini bilemeyiz.
               FAILED olan assertion'i duzelttikten sonra
               digerlerine bakabiliriz.

               Bu yontemi kullandigimizda,
               FAILED olan her bir assertion icin
               duzeltmeleri yapip yeniden testi calistirmamiz gerekir.

            2-) SoftAssert class'indan ayni assert method'larini kullanabiliriz.
               SoftAssert kullandigimizda, TestNG assertion'lar FAILED olsa da
               durumu not alip calismaya devam eder.
               Siz ne zaman rapor ver derseniz
               TestNG yaptigi tum assertion'lari gozden gecirir.
               FAILED olan assertion'lari size raporlar
               ve FAILED olan varsa calismayi durdurur.
               SoftAssert kullanmak icin;
                1- softAssert objesi olustur
                2- tum assertion'lari softAssert objesi kullanarak yap
                3- assertion'lar bitince assertAll() ile rapor iste.

         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Title'in Test icerdigini test edin
        String expectedTitleIcerik ="Test";
        String actualTitle=Driver.getDriver().getTitle();

        SoftAssert softAssert=new SoftAssert();//1.adim SoftAssert objesi olusturma
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik), "Title Test kelimesini icermiyor");

        // url'in https://www.testotomasyonu.com/ oldugunu test edin
        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farkli");

        // arama kutusunun kullanilabilir durumda oldugunu test edin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();

        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(),"Arama kutusuna erisilemiyor");

        // belirlenmis aranacak kelimeyi aratip urun bulundugunu test edin
        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);

        int bulunanSonucSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi > 0, "Kayitli kelime arandiginda urun bulunamadi");


        // Nutella aratip, urun bulunamadigini test edin
        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu
                .sendKeys("Nutella" +Keys.ENTER);

        bulunanSonucSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi == 0,"Arama sonucunda nutella bulundu");

        softAssert.assertAll();//3.adim rapor isteme

        // sayfayi kapatin
        Driver.quitDriver();


    }
}
