import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ObjectEditorPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static Pages.ObjectEditorPage.Type.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */

@Listeners(ScreenFailureTest.class)
public class Test3CreateObject extends BaseTest {



    public void createObject() throws InterruptedException {
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectEditor();
        ObjectEditorPage.clickButtonCreateNew();
        ObjectEditorPage.inputName(name);
        ObjectEditorPage.inputMachineName(machineName);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(INTEGER);
        ObjectEditorPage.selectType(Integer);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(INTEGER);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(STRING);
        ObjectEditorPage.selectType(String);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(STRING);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(BOOLEAN);
        ObjectEditorPage.selectType(Boolean);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(BOOLEAN);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(PASSWORD);
        ObjectEditorPage.selectType(Password);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(PASSWORD);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(EMAIL);
        ObjectEditorPage.selectType(Email);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(EMAIL);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(DATE);
        ObjectEditorPage.selectType(Date);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(DATE);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(DATE_TIME);
        ObjectEditorPage.selectType(DateTime);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(DATE_TIME);
        ObjectEditorPage.clickButtonAddObjectFields();
        ObjectEditorPage.inputFieldName(PRICE);
        ObjectEditorPage.selectType(Price);
        ObjectEditorPage.clickButtonAdd();
        ObjectEditorPage.checkAddedObjectsFields(PRICE);
        ObjectEditorPage.clickButtonCreate();
        ObjectEditorPage.checkAddedObject(name);
    }
}
