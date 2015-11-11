package Pages;

import Base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class MainPage extends BasePage {

    private static final By DASHBOARD_TITLE = By.cssSelector(".dashboard");
    private static final By SETTINGS = By.id("dropdownMenu1");
    private static final By OBJECT_EDITOR = By.xpath("//a[text()='Object editor']");
    private static final By OBJECT_INSTANCE_CREATE = By.xpath("//a[contains(text(),'Create')]");
    private static final By OBJECT_INSTANCE_EDIT = By.xpath("//a[contains(text(),'Edit')]");



    public static void dashboardIsDisplayed(){
        $(DASHBOARD_TITLE).waitUntil(visible,10000);
    }

    public static void goToObjectEditor(){
        $(SETTINGS).click();
        $(OBJECT_EDITOR).click();
        ObjectEditorPage.checkTitleisDisplayed();
    }

    public static void goToCreateObjectInstancePage(String name){
        $(SETTINGS).click();
        $(OBJECT_INSTANCE_CREATE).click();
        $(By.xpath("//a[text()='"+name+"']")).click();
    }

    public static void goToEditObjectInstancePage(String name){
        $(SETTINGS).click();
        $(OBJECT_INSTANCE_EDIT).click();
        $$(By.xpath("//a[text()='"+name+"']")).exclude(not(visible)).get(0).click();
    }

}
