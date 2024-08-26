package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderIleNegatifLoginTesti {
    @AfterTest
    public void teardown() {
        Driver.quitDriver();
    }


    @DataProvider
    public static Object[][] kullaniciBilgileriDataProvider() {

        String[][] kullaniciBilgileri = {{"kullanici1", "12345"},
                                         {"kullanici2", "23456"}, {"kullanici3", "34567"},
                                         {"kullanici4", "45678"}, {"kullanici5", "56789"}};

        return kullaniciBilgileri;//kullaniciBilgiler cift katli bir arraydir
    }

    @Test(dataProvider = "kullaniciBilgileriDataProvider")
    public void cokluNegatifLoginTesti(String username, String password) {

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();


        // kullanici adi ve sifre olarak verilen listedeki
        // tum degerler icin giris yapilamadigini test edin
        testOtomasyonuPage.emailKutusu.sendKeys(username);
        testOtomasyonuPage.passwordKutusu.sendKeys(password);
        testOtomasyonuPage.loginButonu.click();

        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());//hala emailKutusu gorunuyor.giris yapilamamali

        ReusableMethods.bekle(2);


        // kullanici1   12345
        // kullanici2   23456
        // kullanici3   34567
        // kullanici4   45678
        // kullanici5   56789
        //yani disardan bana=> (kullanici adi,  sifre) gelicek.benimde bunu parametre olarak girmem lazim
        //bunlari da bir data providerden alicam.(String username, String password)


    }
}
