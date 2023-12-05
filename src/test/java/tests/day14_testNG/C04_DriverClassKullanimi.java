package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassKullanimi {

    @Test
    public void test01() throws InterruptedException {

        /*
            POM hazirlayanlar
            WebDriver objesini TestBase'den almak yerine, extends keyword'une ihtiyac duymadan
            kullanabilecegimiz, static bir method'da olusturmayi tercih etmistir.
         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratalim
        WebElement searchBox=Driver.getDriver().findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // arama sonuclarini yazdirin
        WebElement aramaSonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(aramaSonucElementi.getText());


        Thread.sleep(3000);


        Driver.quitDriver();

    }
}
