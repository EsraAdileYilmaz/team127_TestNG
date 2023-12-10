package tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class P06_GoogleAramaTesti {

    @Test
    public void googleAramaTesti(){

        //1)google anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //2)cookies uyarisini kabul ederek kapatin
        GooglePage googlePage=new GooglePage();
        googlePage.cookies.click();

        //3)Sayfa basliginin "Google" ifadesi icerdigini test edin
        String expectedTitle="Google";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));


        //4)Arama cubuguna "Nutella" yazip aratin
        googlePage.searchBox
                .sendKeys(ConfigReader.getProperty("googleAranacakKelime")+ Keys.ENTER);

        //5)Bulunan sonuc sayisini yazdirin
        System.out.println(googlePage.sonucYaziElementi.getText());

        //6)Sonuc sayisinin 10 milyondan fazla oldugunu test edin
        String sonucYaziStr=googlePage.sonucYaziElementi.getText();
        String [] sonucYaziArr=sonucYaziStr.split(" ");
        String sonucSayisiStr=sonucYaziArr[1];
        sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");
        int sonucSayisiInt=Integer.parseInt(sonucSayisiStr);

        softAssert.assertTrue(sonucSayisiInt > 10000000);


        softAssert.assertAll();
        Driver.quitDriver();




    }
}
