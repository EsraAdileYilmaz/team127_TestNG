package tests.day17_crossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

import java.util.List;

public class C01 extends TestBaseCross {

    @Test
    public void aramaTesti() {

        driver.get(ConfigReader.getProperty("toUrl"));// driver= DriverCross.getDriver(crossBrowser); boyle bir atama yapildigi icin driver olarak kullaniyoruz.

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));//yeniden locate'leri yazmak gerekiyor.cunku driver degisti

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//div[@class= 'product-box my-2  py-1']"));

        int actualSonucSayisi = bulunanUrunElementleriList.size();

        Assert.assertTrue(actualSonucSayisi > 0);


    }

}
