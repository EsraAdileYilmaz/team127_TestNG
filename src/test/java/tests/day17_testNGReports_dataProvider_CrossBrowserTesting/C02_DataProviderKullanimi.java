package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_DataProviderKullanimi extends TestBaseRapor {



    @Test
    public void cokluAramaTesti(){


       /*
            Bugune kadar ogrendigimiz yontemlerle
            birden fazla eleman icin test yapmak istedigimizde
            elemanlari bir array'e atayip
            for loop ile testleri yapmak istedik.

            ANCAK, ilk failed olan urunde
            assertion exception firlatip calismayi durdurdu ve
            geriye kalan urunlerin var olup olmadigini kontrol etmedi.
         */

        String [] aranacakUrunler={"phone","java","dress","nutella","chair","tea"};
        String arananUrun;
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        int actualUrunSayisi;

        for (int i = 0; i < aranacakUrunler.length ; i++) {

            arananUrun=aranacakUrunler[i];

            // testotomasyonu anasayfaya gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            // verilen urun listesindeki tum urunler icin arama yapip
            // urun listesi : phone, java, dress, nutella, chair, tea
            testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);


            // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin
            actualUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
            Assert.assertTrue(actualUrunSayisi > 0);


        }

    }


    @DataProvider
    public static Object[][] aranacakUrunlerDataProvider() {
        // data provider bize iki katli obje array'i donduren
        // bir method'dur.

        String [][] aranacakUrunler={{"phone"},{"java"},{"dress"},{"nutella"},{"chair"},{"tea"}};

        return aranacakUrunler;
    }




    @Test(dataProvider = "aranacakUrunlerDataProvider")
    public void dataProviderIleCokluAramaTesti(String arananUrun){
        extentTest = extentReports.createTest("data provider test","Belirlenen urun listesi icin arama yapilabilmeli");

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu ana sayfaya gider");

        // verilen urun listesindeki tum urunler icin arama yapip
        // urun listesi : phone, java, dress, nutella, chair, tea
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);
        extentTest.info("verilen listesindeki " +arananUrun +" icin arama yapar");
        ReusableMethods.bekle(2);

        // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin
        int actualUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualUrunSayisi > 0);
        extentTest.pass(arananUrun+" icin arama yapildiginda sonuc bulunabildigini test eder");




    }



}
