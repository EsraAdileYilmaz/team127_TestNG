package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    /*cagrildigi yere bir WebDriver objesi dondurecek
      getDriver() methodu olusturalim.

      getDriver() methodu her seferinde
      driver= new ChromeDriver(); satirini calistirirsa
      her kullanimda yeni bir webdriver objesi olusur.

      Biz ilk kullanimda (yani null iken) yeni webdriver olustursun
      sonraki kullanimlarda atanmis degeri kullansin istiyoruz.



      */


    static WebDriver driver;
    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        if(driver == null){
        driver=new ChromeDriver();
        //yani driver'a ilk atamada chromedriver'i atasin sonrasinda aynisiyla devam etsin.tekrar her seferinde chromedriver'i atamasin
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void closeDriver(){

        driver.close();
    }

    public static void quitDriver(){

        driver.quit();
    }




}
