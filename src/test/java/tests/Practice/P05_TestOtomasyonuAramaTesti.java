package tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P05_TestOtomasyonuAramaTesti {


    @Test
    public void testOtomasyonuAramaTesti(){

        // 1- testotomasyonu anasayfaya gidin ve dogru adrese gittigimizi test edin.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        String expectedUrl="https://testotomasyonu.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenen Url degildir");

        // 2- Electronics linkine tiklayin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.electronicsLinki.click();

        //3- Kenarda bulunan fiyat filtresine min 10, max 200 yazin
        testOtomasyonuPage.minLinki.clear();
        testOtomasyonuPage.minLinki.sendKeys("10");
        testOtomasyonuPage.maxLinki.clear();
        testOtomasyonuPage.maxLinki.sendKeys("200");

        //4- Filtreleme yapin
        testOtomasyonuPage.filterPriceButton.sendKeys(Keys.ENTER);

        //5-Arama sonunda urun bulundugunu test edin
        String actualSonucYazi=testOtomasyonuPage.sonucYaziElementi.getText();
        String expectedSonucYazi="11 Products Found";
        softAssert.assertEquals(actualSonucYazi,expectedSonucYazi,"Beklenen sonuc degildir");


        softAssert.assertAll();
        Driver.quitDriver();



    }
}
