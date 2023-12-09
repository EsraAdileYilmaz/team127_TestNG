package tests.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class P02_TrendyolTesti {

    @Test
    public void trendyolTesti(){

        //Trendyol anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));

        //cookies'i kabul edin
        TrendyolPage trendyolPage=new TrendyolPage();
        trendyolPage.cookies.click();

        //account butonunun uzerinde gelip,click yapiniz
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(trendyolPage.accountIcon).click().perform();


        //fake email,password gonderin
        Faker faker=new Faker();
        ReusableMethods.bekle(2);
        trendyolPage.registerEmailBox.sendKeys(faker.internet().emailAddress());
        trendyolPage.registerPasswordBox.sendKeys(faker.internet().password());

        //genderwomen ve sign up butonlarina basin
        trendyolPage.genderWomenButton.click();
        trendyolPage.signupButonu.click();













        Driver.quitDriver();

    }
}
