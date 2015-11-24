package Pages;

import Base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

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
    private static final By OBJECT_INSTANCE = By.xpath("//a[contains(text(),'Objects')]");
    private static final By PERMISSIONS = By.xpath("//a[contains(text(),'Permissions')]");
    private static final By LOG_OUT = By.xpath("//a[contains(text(),'Log out')]");



    public static void dashboardIsDisplayed(){
        $(DASHBOARD_TITLE).waitUntil(visible, 10000);
    }

    public static void goToObjectEditor(){
        $(SETTINGS).click();
        $(OBJECT_EDITOR).click();
        ObjectEditorPage.checkTitleisDisplayed();
    }

    public static void goToObjectInstancePage(String name){
        $(SETTINGS).click();
        $(OBJECT_INSTANCE).click();
        $(By.xpath("//a[text()='" + name + "']")).click();
    }

    public static void goToPermissionsPage(){
        $(SETTINGS).click();
        $(PERMISSIONS).click();
        PermissionsPage.checkTitleIsUserRoles();
    }

    public static void checkInstanceIsEnable(String name){
        $(SETTINGS).click();
        $(OBJECT_INSTANCE).click();
        $(By.xpath("//a[text()='" + name + "']")).should(not(exist));
    }

    public static void logOut(){
        $(SETTINGS).click();
        $(LOG_OUT).click();
        assertTrue($("span").waitUntil(visible, 6000).getText().contains("The vision behind Skyportal is to consolidate reporting and administration of all services delivered by Purity in to one pane of glass"));
    }

}
