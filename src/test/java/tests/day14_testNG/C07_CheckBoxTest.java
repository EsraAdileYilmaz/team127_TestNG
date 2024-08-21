package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_CheckBoxTest {

    @Test
    public void test01() {

        //	a. Verilen web sayfasına gidin.  https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        testOtomasyonuFormPage.sirtAgrisiCheckboxKutusu.click();
        testOtomasyonuFormPage.carpintiCheckboxKutusu.click();


        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(testOtomasyonuFormPage.sirtAgrisiCheckboxKutusu.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.carpintiCheckboxKutusu.isSelected());


        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
        //1-Burda Seker ve Epilepsi checkbox’larininin oldugu sayfa gorunmedigi icin
        // sayfayi asagi kaydirmam lazim

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);

        Assert.assertFalse(testOtomasyonuFormPage.sekerCheckboxKutusu.isSelected());
        Assert.assertFalse(testOtomasyonuFormPage.epilepsiCheckboxKutusu.isSelected());

        Driver.quitDriver();


    }
}
