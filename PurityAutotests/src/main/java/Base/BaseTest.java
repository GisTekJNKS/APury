package Base;

import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.*;


import java.util.Random;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class BaseTest {

    public static String BASE_URL="http://purityIT:HardPassword@purity_ws.andersenlab.com";
    public static String name = "AUTOTEST";
    public static String countryInstanceName = "Test_country_";
    public static String machineName = "MNAUTOTEST";
    public static final String INTEGER = "Integer";
    public static final String STRING = "String";
    public static final String BOOLEAN = "Boolean";
    public static final String PASSWORD = "Password";
    public static final String EMAIL = "Email";
    public static final String DATE = "Date";
    public static final String DATE_TIME = "DateTime";
    public static final String PRICE = "Price";

    @BeforeSuite
    public void PrepareTestData() {
        int r = (new Random()).nextInt(9999);
        name += r;
        machineName += r;
        countryInstanceName += r;
    }

    @BeforeMethod
    public static void setup(){
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.startMaximized=true;
        Configuration.baseUrl = System.getProperty("baseUrl",BASE_URL);
        open("/");
        Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout","3000"));

    }


    @AfterMethod
    public static void tearDown(){
        clearBrowserCache();
        close();
    }

}
