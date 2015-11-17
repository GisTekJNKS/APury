import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.management.ObjectInstance;

import static Pages.ObjectEditorPage.Type.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */

@Listeners(ScreenFailureTest.class)
public class Test3CRUDObject extends BaseTest {


    @Test
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

    @Test
    public void createObjectInstance(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectInstancePage(name);
        ObjectInstancePage.checkTitleIsListOfObjects(name);
        ObjectInstancePage.clickButtonCreateNew();
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

    @Test
    public void editObjectInstance(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectInstancePage(name);
        ObjectInstancePage.checkTitleIsListOfObjects(name);
        ObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField(Integer, "999");
        CreateObjectInstancePage.inputField(String, "autotester");
        CreateObjectInstancePage.inputField(Boolean, "");
        CreateObjectInstancePage.inputField(Password, "PASWORD");
        CreateObjectInstancePage.inputField(Email, "Autotester@gmail.com");
        CreateObjectInstancePage.inputField(Date, "23");
        CreateObjectInstancePage.inputField(DateTime, "23 10:00");
        CreateObjectInstancePage.inputField(Price,"999");
        ObjectInstancePage.clickButtonEdit();
        ObjectInstancePage.checkSuccessfulUpdete();
    }
    @Test
    public void editObjectInstanceWrongData(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectInstancePage(name);
        ObjectInstancePage.checkTitleIsListOfObjects(name);
        ObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField(Integer, "1001");
        CreateObjectInstancePage.inputField(String, "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890777");
        CreateObjectInstancePage.inputField(Email, "Autotester");
        CreateObjectInstancePage.inputField(Price,"-1");
        ObjectInstancePage.clickButtonEdit();
        ObjectInstancePage.checkErrorMessage(ObjectInstancePage.ErrorMessageEditObjPage.WrongIntegerData, INTEGER);
        ObjectInstancePage.checkErrorMessage(ObjectInstancePage.ErrorMessageEditObjPage.WrongStringData, STRING);
        ObjectInstancePage.checkErrorMessage(ObjectInstancePage.ErrorMessageEditObjPage.WrongEmail, EMAIL);
    }

    @Test
    public void removeObjectInstance() {
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectInstancePage(name);
        ObjectInstancePage.checkTitleIsListOfObjects(name);
        ObjectInstancePage.clickButtonDelete();
    }

    @Test
    public void removeObjectInstanceFull() {
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectEditor();
        ObjectEditorPage.clickDeleteObject(name);
    }

}
