package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Created by daups_000 on 18.10.2015.
 */
public class Waiter {

    public static void waitForJquery(long timeout) {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) executeJavaScript("return jQuery.active == 0");
            }
        });
    }

    // custom waiter with default timeout
    public static void waitForPageToLoad() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return executeJavaScript("return document.readyState").equals("complete");
            }
        });
    }


}
