package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZerowebappPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_SoftAssertion {


    @Test
    public void softAssertionTesti(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));


        // 2. webbappsecurity ana sayfaya gittiginizi dogrulayin
        String expectedUrl="http://zero.webappsecurity.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfada degiliz");

        // 3. Sign in butonuna basin
        ZerowebappPage zerowebappPage=new ZerowebappPage();
        zerowebappPage.signInLinki.click();

        // 4. Login kutusuna “username” yazin
        zerowebappPage.loginBox.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        zerowebappPage.passwordBox.sendKeys("password");

        // 6. Sign in tusuna basin
        zerowebappPage.signInButton.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zerowebappPage.onlineBankingLinki.isDisplayed(),"Giris yapilamadi");

        // 9. Online banking menusunu tiklayin
        zerowebappPage.onlineBankingLinki.click();

        //10. Pay Bills sayfasina gidin
        zerowebappPage.payBillsLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zerowebappPage.purchaseForeignCurrencyLinki.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zerowebappPage.pcCurrencyDropdownElementi.isEnabled(),"Currency dropdowna erisilemiyor");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select=new Select(zerowebappPage.pcCurrencyDropdownElementi);//dropdown menuden bisey secmek icin select class'i olusturulmali
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedOption="Eurozone (euro)";
        String actualOption=select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOption,expectedOption,"Eurozone (euro) secilemedi");


        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        List<WebElement> dropdownElementleriList=select.getOptions();
        int expectedDropdownSize=16;
        int actualDropdownSize=dropdownElementleriList.size();
        softAssert.assertEquals(actualDropdownSize,expectedDropdownSize,"Dropdown beklenen boyutta degil");


        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<String> dropdownYazilariList= ReusableMethods.stringListeDonustur(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdown Canada (dollar)'i icermemektedir");

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();

























    }
}
