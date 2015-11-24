package Pages;

import Base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

/**
 * Created by John on 19.11.2015.
 */
public class PermissionsPage extends BasePage {

    private static final By TITLE = By.tagName("h2");
    //private static final By EDIT_BUTTON = By.xpath("//a[contains(text(),'Edit')]");
    private static final By EDIT_BUTTON = By.cssSelector(".glyphicon.glyphicon-pencil");




    public static void editRole(String nameOfRole){
        SelenideElement table = $("tbody");
        SelenideElement row = table.$$(By.tagName("tr")).get(getNumberOfRow(nameOfRole));
        //int s = row.$$(EDIT_BUTTON).size(); ПОЧЕМУ ОН НАХОДИТ 4 ОБЪЕКТА по xpath?????
        row.$(EDIT_BUTTON).click();
        EditPermissionPage.checkTitleIsEditRole();
    }

    public static void checkTitleIsUserRoles(){
        $(TITLE).waitUntil(visible, 6000).shouldHave(text("User roles"));
    }



}
