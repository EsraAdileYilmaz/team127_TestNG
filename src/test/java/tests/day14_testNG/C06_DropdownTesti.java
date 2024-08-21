package tests.day14_testNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C06_DropdownTesti {

    @Test
    public void dropdownTesti() {

        //● https://testotomasyonu.com/form adresine gidin.
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        //hazir locateler icin, locatelerin icinde bulundugu class'tan bir obje olusturmamiz lazim
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();//Objeyi class icinde 1 kez olusturmak yeterli oluyor
        Select selectGun = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(0));//listedeki ilk elementi(gun) getir
        selectGun.selectByIndex(5);

        //	2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(1));//listedeki ikinci elementi(ay) getir
        selectAy.selectByValue("nisan");

        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuFormPage.dropdownMenuElementleriList.get(2));//listedeki ucuncu elementi(yil) getir
        selectYil.selectByVisibleText("1990");


        //	4. Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText() + "/" +
                           selectAy.getFirstSelectedOption().getText() + "/" +
                           selectYil.getFirstSelectedOption().getText());


        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<String> aylarListesi = ReusableMethods.stringListeDonustur(selectAy.getOptions());
        System.out.println(aylarListesi);

        //	6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(selectAy.getOptions().size(), 13);//1.yol
        Assert.assertEquals(aylarListesi.size(), 13);//2.yol


        Driver.quitDriver();


    }


}
