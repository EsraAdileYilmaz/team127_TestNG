package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;
public class TestBaseCross {
    protected WebDriver driver;

    @Parameters("crossBrowser")
    @BeforeMethod
    public void setUp(@Optional String crossBrowser){//@Parameters("crossBrowser") icindeki degeri parametre olarak alir

        driver= DriverCross.getDriver(crossBrowser);
    }

    @AfterMethod
    public void tearDown(){
        DriverCross.quitDriver();
    }
}













