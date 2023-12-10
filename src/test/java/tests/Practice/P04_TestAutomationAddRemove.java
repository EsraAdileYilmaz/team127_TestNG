package tests.Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuAddRemovePage;
import utilities.ConfigReader;
import utilities.Driver;

public class P04_TestAutomationAddRemove {

   @Test
   public void testOtomasyonAddRemoveTesti(){

     //1)"https://testotomasyonu.com/addremove/" adresine gidin
       Driver.getDriver().get(ConfigReader.getProperty("toAddRemoveUrl"));

     //2)Add element butonuna basin
       TestOtomasyonuAddRemovePage testOtomasyonuAddRemovePage=new TestOtomasyonuAddRemovePage();
       testOtomasyonuAddRemovePage.addButonu.click();


     //3)Remove butonu'nun gorunur oldugunu test edin
       SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue(testOtomasyonuAddRemovePage.removeButonu.isDisplayed(),"Remove butonu gozukmuyor");

     //4)Remove tusuna basin
       testOtomasyonuAddRemovePage.removeButonu.click();

     //5)"Add/Remove Elements" yazisinin gorunur oldugunu test edin.
      softAssert.assertTrue(testOtomasyonuAddRemovePage.addRemoveYazisiLinki.isDisplayed(),"Add/Remove Elements yazisi gozukmuyor");



    softAssert.assertAll();
    Driver.quitDriver();





   }

}
