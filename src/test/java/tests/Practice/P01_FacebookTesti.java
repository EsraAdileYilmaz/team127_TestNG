package tests.Practice;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P01_FacebookTesti {

    @Test
    public void facebookTesti(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));


        //2- POM'a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        FacebookPage facebookPage=new FacebookPage();
        facebookPage.cookies.click();

        //3- Faker class'ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordBox.sendKeys(faker.internet().password());
        facebookPage.seconnecterButton.click();


        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.message.isDisplayed());
        System.out.println(facebookPage.message.getText());


        //5- Sayfayi kapatin.
        Driver.quitDriver();

    }




}
