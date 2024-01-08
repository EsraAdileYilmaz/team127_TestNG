package tests.Practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.EasybusticketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class P09_Easybusticket_SignUpForm extends TestBaseRapor {

    @Test
    public void signUpForm(){
        extentTest=extentReports.createTest("signUpTest","The visitor enters the homepage with the URL");


        //1)The visitor enters the homepage with the URL "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easybusticketUrl"));
        extentTest.info("The visitor enters the homepage with the URL");

        //2)When the page is opened, it accepts the cookies section
        EasybusticketPage easybusticketPage=new EasybusticketPage();
        easybusticketPage.cookies.click();
        extentTest.info("it accepts the cookies section");

        //3)Visitor clicks on the "Sign Up" link in the place holder in the header section of the home page to register
        easybusticketPage.signUpLink.click();
        extentTest.info("Visitor clicks on the Sign Up link");

        //4)Enter valid information in the First Name, Last Name, Country, Mobile, Username,
        // Email, Password, Confirm Password boxes on the Sign Up page
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        String fakePassword=faker.internet().password();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().name())
                .sendKeys(Keys.TAB)
                .sendKeys("789674923")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .perform();





    }
}
