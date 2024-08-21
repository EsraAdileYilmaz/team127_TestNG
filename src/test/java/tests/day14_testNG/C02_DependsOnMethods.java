package tests.day14_testNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    /*
        -dependsOnMethods oncelik sirasina karismaz.

        1)Eger sirasi gelen bir test, dependsOnMethods ile baska bir method'a bagli ise
        once bagli olunan testin calisip, PASSED olmasini kontrol eder.

        2)Bagli olunan test calismazsa veya calisir ama FAILED olursa
        bu durumda bagli olan test method'u calismaz, ignore olarak isaretlenir.

        3)Normalde her bir test method'u bagimsiz olarak calistirilabilir.
        Ancak dependsOnMethods ile bagli olan iki method'dan
        bagli olan run edilirse, oncelikle bagli olunan test method'unun calismasini saglar,
        bagli olunan method calisip PASSED olursa, bagli olan test method'da calisir.

     */

    @Test(dependsOnMethods = "testOtomasyonuTesti")
    public void amazonTesti() {

        System.out.println("Amazon testi PASSED");
        //bu methodda amazonTestinin calismasi testOtomasyonuTesti'nin calismasina baglidir.
        //once testOtomasyonuTesti() calisir ve PASSED olursa amazonTesti() calisir.
        //FAILED olursa amazonTesti() ignore edilir.CALISMAZ
    }

    @Test
    public void testOtomasyonuTesti() {
        //Assert.assertTrue(false);
        System.out.println("Test Otomasyonu testi PASSED");
    }

    @Test(dependsOnMethods = "amazonTesti")
    public void wiseQuarterTesti() {

        System.out.println("Wise Quarter testi PASSED");
    }


}
