import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ObjectEditorPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by John on 27.10.2015.
 */

@Listeners(ScreenFailureTest.class)
public class Test4CreateObjectWrongData extends BaseTest{

    @Test
    public void emptyName(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectEditor();
        ObjectEditorPage.clickButtonCreateNew();
        ObjectEditorPage.inputMachineName(machineName);
        ObjectEditorPage.clickButtonCreate();
        ObjectEditorPage.checkErrorMessage(ObjectEditorPage.ErrorMessage.NameCannotBeBlank);
    }

    @Test
    public void emptyMachineName(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectEditor();
        ObjectEditorPage.clickButtonCreateNew();
        ObjectEditorPage.inputName(name);
        ObjectEditorPage.clickButtonCreate();
        ObjectEditorPage.checkErrorMessage(ObjectEditorPage.ErrorMessage.MachineNameCannotBeBlank);
    }

    @Test
    public void emptyMandaritoryFields(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToObjectEditor();
        ObjectEditorPage.clickButtonCreateNew();
        ObjectEditorPage.clickButtonCreate();
        ObjectEditorPage.checkErrorMessage(ObjectEditorPage.ErrorMessage.MachineNameCannotBeBlank);
        ObjectEditorPage.checkErrorMessage(ObjectEditorPage.ErrorMessage.NameCannotBeBlank);
    }

}
