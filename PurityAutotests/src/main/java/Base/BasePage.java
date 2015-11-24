package Base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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

    protected static int getNumberOfRow(String name){
        SelenideElement element = $("tbody");
        ElementsCollection rows = element.$$(By.tagName("tr"));
        int temp = rows.size();
        for (int i=0;i<rows.size();i++){
            String sh = rows.get(i).getText();
            ElementsCollection cols = rows.get(i).$$("td");
            int temp2 = cols.size();
            for (SelenideElement s:cols) {
                String ss = s.getText();
                if (ss.contentEquals(name)) {
                    return i;
                }
            }
        }
        return Integer.parseInt(null);
    }



}
