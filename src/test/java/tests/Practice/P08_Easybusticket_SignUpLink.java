package tests.Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EasybusticketPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class P08_Easybusticket_SignUpLink extends TestBaseRapor {


    @Test
    public void signUpTest(){
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

        //4)When the visitor enters the Sign Up page, they see the text "Sign Up your Account"
        SoftAssert softAssert=new SoftAssert();
        String expectedText="Sign Up your Account";
        String actualText=easybusticketPage.textOfSignUpyourAccount.getText();
        softAssert.assertEquals(expectedText,actualText);
        softAssert.assertAll();
        extentTest.pass("The visitor sees Sign Up your Account");

        extentTest.info("page closes");


    }
}
