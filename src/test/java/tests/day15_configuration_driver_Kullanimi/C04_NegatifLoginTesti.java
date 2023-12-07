package tests.day15_configuration_driver_Kullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegatifLoginTesti {

    // 1- https://www.testotomasyonu.com/ anasayfasina gidin
    // 2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(2);
        // 2-account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();

        // 3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olun
        ReusableMethods.bekle(2);
        testOtomasyonuPage.loginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        //Eger hala emailKutusu veya passwordKutusu veya signInButonu gorunuyorsa basarili giris yapilamamistir
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(2);
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();

        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olun
        ReusableMethods.bekle(2);
        testOtomasyonuPage.loginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        //Eger hala emailKutusu veya passwordKutusu veya signInButonu gorunuyorsa basarili giris yapilamamistir
        Assert.assertTrue(testOtomasyonuPage.passwordKutusu.isDisplayed());


        Driver.quitDriver();

    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(2);
        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.accountButonu.click();

        // 3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olun
        ReusableMethods.bekle(2);
        testOtomasyonuPage.loginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        //Eger hala emailKutusu veya passwordKutusu veya signInButonu gorunuyorsa basarili giris yapilamamistir
        Assert.assertTrue(testOtomasyonuPage.passwordKutusu.isDisplayed());


        Driver.quitDriver();

    }



}
