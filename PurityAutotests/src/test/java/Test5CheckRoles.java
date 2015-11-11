import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by John on 28.10.2015.
 */
@Listeners(ScreenFailureTest.class)
public class Test5CheckRoles extends BaseTest {


    public void checkPermissions() throws InterruptedException {
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToCreateObjectInstancePage("TEST_COUNTRY");
        CreateObjectInstancePage.checkTitleIsDisplayed();
        CreateObjectInstancePage.chooseRoot();
        CreateObjectInstancePage.inputField("name", countryInstanceName);
        CreateObjectInstancePage.clickButtonCreate();
        CreateObjectInstancePage.checkInstanceWasAdded();
        EditObjectInstancePage.checkPathOfCountryInstance();
        EditObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField("name", "Test_country");
        EditObjectInstancePage.clickButtonEdit();
        EditObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        EditObjectInstancePage.checkSuccessfulUpdete();
        EditObjectInstancePage.checkNameInstanceEnable("Test_country");
        EditObjectInstancePage.clickButtonDelete();
        EditObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        MainPage.goToEditObjectInstancePage("User");
        EditObjectInstancePage.checkTitleIsListOfObjects("User");
        EditObjectInstancePage.checkNameInstanceEnable("distributor_test_admin");
        EditObjectInstancePage.checkPathOfDistributorInstance();
        EditObjectInstancePage.checkControlButtonsEnable();
        EditObjectInstancePage.clickButtonEditObject(); //Добавить в метод имя инстанса у которой нажимаем кнопку увше
        CreateObjectInstancePage.checkValueInFieldIs("Test_country");
        CreateObjectInstancePage.checkValueInFieldIs("distributor_test_admin");
        CreateObjectInstancePage.checkValueInFieldIs("distributor_admin@gmail.com");
        CreateObjectInstancePage.checkRoleIs("Distributor Admin");
//        17) отсутствует - не реализовано
//        CreateObjectInstancePage.inputField("Name","distributor_test_admin_1");
//        EditObjectInstancePage.clickButtonEdit();
//        EditObjectInstancePage.checkTitleIsEditObject();
//        EditObjectInstancePage.checkTitleIsDisplayed("User");
//        EditObjectInstancePage.checkSuccessfulUpdete();
//        EditObjectInstancePage.checkNameInstanceEnable("distributor_test_admin_1");


        Thread.sleep(3000);

    }
}
