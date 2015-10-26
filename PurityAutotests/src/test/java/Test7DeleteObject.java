import Base.BaseTest;
import Pages.EditObjectInstancePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class Test7DeleteObject extends BaseTest {


    public void createObject() {
        LoginPage.authorizeAsAdmin();
        MainPage.goToEditObjectInstancePage(/*name*/"AUTOTEST1632");
        EditObjectInstancePage.checkTitleIsDisplayed(/*name*/"AUTOTEST1632");
        EditObjectInstancePage.clickButtonDelete();
    }


}
