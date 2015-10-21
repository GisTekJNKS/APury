import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.ObjectEditorPage.Type.*;
import static Pages.ObjectEditorPage.Type.Price;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class Test5EditObjectInstance extends BaseTest {

    @Test
    public void createObject(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToEditObjectInstancePage(/*name*/"AUTOTEST1632");
        EditObjectInstancePage.checkTitleIsDisplayed();
        EditObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField(Integer, "999");
        CreateObjectInstancePage.inputField(String, "autotester");
        CreateObjectInstancePage.inputField(Boolean, "");
        CreateObjectInstancePage.inputField(Password, "PASWORD");
        CreateObjectInstancePage.inputField(Email, "Autotester@gmail.com");
        CreateObjectInstancePage.inputField(Date, "23");
        CreateObjectInstancePage.inputField(DateTime, "23 10:00");
        CreateObjectInstancePage.inputField(Price,"999");
        EditObjectInstancePage.clickButtonEdit();
        EditObjectInstancePage.checkSuccessfulUpdete();
    }
}
