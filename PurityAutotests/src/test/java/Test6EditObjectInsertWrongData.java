import Base.BaseTest;
import Pages.CreateObjectInstancePage;
import Pages.EditObjectInstancePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.ObjectEditorPage.Type.*;
import static Pages.ObjectEditorPage.Type.Email;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class Test6EditObjectInsertWrongData extends BaseTest{

    @Test
    public void createObject(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToEditObjectInstancePage(/*name*/"AUTOTEST1632");
        EditObjectInstancePage.checkTitleIsDisplayed();
        EditObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField(Integer, "1001");
        CreateObjectInstancePage.inputField(String, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890777");
        CreateObjectInstancePage.inputField(Email, "Autotester");
        CreateObjectInstancePage.inputField(Price,"-1");
        EditObjectInstancePage.checkErrorMessage(EditObjectInstancePage.ErrorMessageEditObjPage.WrongIntegerData, INTEGER);
        EditObjectInstancePage.checkErrorMessage(EditObjectInstancePage.ErrorMessageEditObjPage.WrongStringData,STRING);
        EditObjectInstancePage.checkErrorMessage(EditObjectInstancePage.ErrorMessageEditObjPage.WrongEmail,EMAIL);
    }
}
