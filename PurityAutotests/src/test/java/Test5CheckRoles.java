import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.management.ObjectInstance;

/**
 * Created by John on 28.10.2015.
 */
@Listeners(ScreenFailureTest.class)
public class Test5CheckRoles extends BaseTest {

    @Test
    public void test1SaveDeletedPermissions() {
        LoginPage.authorizeAsAdmin();
        MainPage.goToPermissionsPage();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, false);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, false);
        EditPermissionPage.clickButtonEdit();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, false);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, false);
    }

    @Test
    public void test2PermissionsEnable (){
        LoginPage.authorizeAsCountryAdmin();
        MainPage.checkInstanceIsEnable("TEST_COUNTRY");
    }

    @Test
    public void test3PermissionCreate(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToPermissionsPage();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, true);
        EditPermissionPage.clickButtonEdit();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, true);
        EditPermissionPage.clickButtonEdit();
        MainPage.logOut();
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToObjectInstancePage("TEST_COUNTRY");
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        ObjectInstancePage.checkCreateNewIsAvailable(true);
        ObjectInstancePage.checkEditIsAvailable(false);
        ObjectInstancePage.checkDeleteIsAvailable(false);
        ObjectInstancePage.clickButtonCreateNew();
        CreateObjectInstancePage.checkTitleIsDisplayed();
    }

    @Test
    public void test4PermissionEdit(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToPermissionsPage();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, false);
        EditPermissionPage.clickButtonEdit();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, false);
        EditPermissionPage.clickButtonEdit();
        MainPage.logOut();
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToObjectInstancePage("TEST_COUNTRY");
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        ObjectInstancePage.checkCreateNewIsAvailable(false);
        ObjectInstancePage.checkEditIsAvailable(true);
        ObjectInstancePage.checkDeleteIsAvailable(false);
        ObjectInstancePage.clickButtonEditObject();
        ObjectInstancePage.checkTitleIsEditObject();
    }

    @Test
    public void test5PermissionEditAndDelete(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToPermissionsPage();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, true);
        EditPermissionPage.clickButtonEdit();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, false);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, true);
        EditPermissionPage.clickButtonEdit();
        MainPage.logOut();
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToObjectInstancePage("TEST_COUNTRY");
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        ObjectInstancePage.checkCreateNewIsAvailable(false);
        ObjectInstancePage.checkEditIsAvailable(true);
        ObjectInstancePage.checkDeleteIsAvailable(true);
    }

    @Test
    public void test5AllPermissionIsAvailable(){
        LoginPage.authorizeAsAdmin();
        MainPage.goToPermissionsPage();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, true);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.tapCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, true);
        EditPermissionPage.clickButtonEdit();
        PermissionsPage.editRole("Country Admin");
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Create, true);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Modify, true);
        EditPermissionPage.checkValueOfCheckbox("TEST_COUNTRY", EditPermissionPage.checkBox.Delete, true);
        EditPermissionPage.clickButtonEdit();
        MainPage.logOut();
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToObjectInstancePage("TEST_COUNTRY");
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        ObjectInstancePage.checkCreateNewIsAvailable(true);
        ObjectInstancePage.checkEditIsAvailable(true);
        ObjectInstancePage.checkDeleteIsAvailable(true);
    }














//        CreateObjectInstancePage.checkTitleIsDisplayed();
//        CreateObjectInstancePage.chooseRoot();
//        CreateObjectInstancePage.inputField("name", countryInstanceName);
//        CreateObjectInstancePage.clickButtonCreate();
//        CreateObjectInstancePage.checkInstanceWasAdded();
//        ObjectInstancePage.checkPathOfCountryInstance();
//        ObjectInstancePage.clickButtonEditObject();
//        CreateObjectInstancePage.inputField("name", "Test_country");
//        ObjectInstancePage.clickButtonEdit();
//        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
//        ObjectInstancePage.checkSuccessfulUpdete();
//        ObjectInstancePage.checkNameInstanceEnable("Test_country");
//        ObjectInstancePage.clickButtonDelete();
//        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
//        MainPage.goToObjectInstancePage("User");
//        ObjectInstancePage.checkTitleIsListOfObjects("User");
//        ObjectInstancePage.checkNameInstanceEnable("distributor_test_admin");
//        ObjectInstancePage.checkPathOfDistributorInstance();
//        ObjectInstancePage.checkControlButtonsEnable();
//        ObjectInstancePage.clickButtonEditObject(); //Добавить в метод имя инстанса у которой нажимаем кнопку увше
//        CreateObjectInstancePage.checkValueInFieldIs("Test_country");
//        CreateObjectInstancePage.checkValueInFieldIs("distributor_test_admin");
//        CreateObjectInstancePage.checkValueInFieldIs("distributor_admin@gmail.com");
//        CreateObjectInstancePage.checkRoleIs("Distributor Admin");
//        17) отсутствует - не реализовано
//        CreateObjectInstancePage.inputField("Name","distributor_test_admin_1");
//        ObjectInstancePage.clickButtonEdit();
//        ObjectInstancePage.checkTitleIsEditObject();
//        ObjectInstancePage.checkTitleIsDisplayed("User");
//        ObjectInstancePage.checkSuccessfulUpdete();
//        ObjectInstancePage.checkNameInstanceEnable("distributor_test_admin_1");





}
