import Base.BaseTest;
import Pages.CreateObjectInstancePage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ObjectEditorPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.ObjectEditorPage.Type.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class Test4CreateObjectInstance extends BaseTest {


    public void createObject(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToCreateObjectInstancePage(/*name*/"AUTOTEST1632");
        CreateObjectInstancePage.checkTitleIsDisplayed();
        CreateObjectInstancePage.chooseRoot();
        CreateObjectInstancePage.inputField(Integer, "1000");
        CreateObjectInstancePage.inputField(String, "autotest");
        CreateObjectInstancePage.inputField(Boolean, "");
        CreateObjectInstancePage.inputField(Password,"123");
        CreateObjectInstancePage.inputField(Email,"Autotest@gmail.com");
        CreateObjectInstancePage.inputField(Date,"22");
        CreateObjectInstancePage.inputField(DateTime, "22 9:00");
        CreateObjectInstancePage.inputField(Price,"1000");
        CreateObjectInstancePage.clickButtonCreate();
    }
}
