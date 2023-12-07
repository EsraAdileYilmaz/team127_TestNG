package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    Bu class configuration.properties icindeki dosyalari okuyup
    bizim class'larimizda kullanmamizi saglar.Yani dosya okuma
    islemlerini icerir.

    "ConfigReader" bizim joker elemanimizdir.
    ConfigReader.getProperty()); seklinde bir kullanimla istedigimizi elde ederiz.

     */

    static Properties properties;//javadaki properties ozelliklerini kullanmak icin bu objeyi olusturuyoruz.
    static {// static blok herseyden once calisir ve gerekli ayarlamalari yapar
        String dosyaYolu= "configuration.properties";
        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            properties= new Properties();
            properties.load(fis);//bu satirda properties ustundeki tum bilgiler yuklenmis olacak
            //properties uzerine yuklenen degerleri key=value seklinde tutar.
            //biz cagirmak icin key'ini yazariz oda bize value'sunu dondurur

        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);
    }



}
