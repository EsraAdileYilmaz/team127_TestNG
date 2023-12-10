package tests.Practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class P03_AutomationExerciseTesti {

    @Test
    public void automationExerciseTesti(){

      //1)"https:// automationexercise.com/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

      //2)Category bolumundeki elementleri locate edin ve 3 element oldugunu test edin.
        AutomationExercisePage automationExercisePage=new AutomationExercisePage();
        List<WebElement> categoryElementleriListi=automationExercisePage.categoryElementleriListi;
        int actualIcerik=categoryElementleriListi.size();
        int expectedIcerik=3;
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualIcerik,expectedIcerik,"Category elementleri beklenenden farkli sayidadir");


      //3)Category isimlerini yazdirin
        List<String> categoryElementleriYazilari= ReusableMethods.stringListeDonustur(categoryElementleriListi);
        System.out.println(categoryElementleriYazilari);//[WOMEN, MEN, KIDS]

      //4) sayfada 147 link oldugunu test edin.
        List<WebElement> linkElementlerListi=automationExercisePage.linkElementleriListi;
        int expectedLinkSayisi=147;
        int actualLinkSayisi=linkElementlerListi.size();
        softAssert.assertEquals(actualLinkSayisi,expectedLinkSayisi,"Link sayisi beklenenden farkli cikti");

      //5)Products linkine tiklayin
        automationExercisePage.productsLinki.click();

      //6)"special offer" yazisinin gorundugunu test edin
        softAssert.assertTrue(automationExercisePage.specialOfferYazisi.isDisplayed(),"special offer yazisi gozukmuyor");

        Driver.quitDriver();
        softAssert.assertAll();

    }
}
