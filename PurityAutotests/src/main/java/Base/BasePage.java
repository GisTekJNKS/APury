package Base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class BasePage {

    protected static void checkExpectedElements (List<By> elements){
        for (By element : elements){
            $(element).shouldBe(visible);
        }
    }




}
