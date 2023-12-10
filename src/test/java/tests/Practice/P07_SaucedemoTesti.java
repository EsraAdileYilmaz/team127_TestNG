package tests.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P07_SaucedemoTesti {

    @Test
    public void saucedemoAramaTesti(){

      //1)"https://www.saucedemo.com" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

      //2)Username kutusuna "standard_user" yazdirin
        SaucedemoPage saucedemoPage=new SaucedemoPage();
        saucedemoPage.usernameLinki.sendKeys("standard_user");

      //3)Password kutusuna "secret_sauce" yazdirin
        saucedemoPage.passwordLinki.sendKeys("secret_sauce");

      //4)Login tusuna basin
        saucedemoPage.loginButton.click();

      //5)Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrunIsim=saucedemoPage.ilkUrunIsim.getText();
        saucedemoPage.ilkUrunIsim.click();

      //6)Add to Card butonuna basin
        saucedemoPage.addtocardButton.click();

      //7)Alisveris sepetine tiklayin
        saucedemoPage.alisverisSepeti.click();

      //8)Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin.
        Assert.assertTrue(saucedemoPage.continueShoppingButton.isDisplayed());

        Driver.quitDriver();



    }

}
