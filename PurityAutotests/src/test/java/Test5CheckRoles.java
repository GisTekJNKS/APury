import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.*;
import org.testng.annotations.Listeners;

/**
 * Created by John on 28.10.2015.
 */
@Listeners(ScreenFailureTest.class)
public class Test5CheckRoles extends BaseTest {


    public void checkPermissions() throws InterruptedException {
        LoginPage.authorizeAsCountryAdmin();
        MainPage.goToObjectInstancePage("TEST_COUNTRY");
        CreateObjectInstancePage.checkTitleIsDisplayed();
        CreateObjectInstancePage.chooseRoot();
        CreateObjectInstancePage.inputField("name", countryInstanceName);
        CreateObjectInstancePage.clickButtonCreate();
        CreateObjectInstancePage.checkInstanceWasAdded();
        ObjectInstancePage.checkPathOfCountryInstance();
        ObjectInstancePage.clickButtonEditObject();
        CreateObjectInstancePage.inputField("name", "Test_country");
        ObjectInstancePage.clickButtonEdit();
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        ObjectInstancePage.checkSuccessfulUpdete();
        ObjectInstancePage.checkNameInstanceEnable("Test_country");
        ObjectInstancePage.clickButtonDelete();
        ObjectInstancePage.checkTitleIsListOfObjects("TEST_COUNTRY");
        MainPage.goToObjectInstancePage("User");
        ObjectInstancePage.checkTitleIsListOfObjects("User");
        ObjectInstancePage.checkNameInstanceEnable("distributor_test_admin");
        ObjectInstancePage.checkPathOfDistributorInstance();
        ObjectInstancePage.checkControlButtonsEnable();
        ObjectInstancePage.clickButtonEditObject(); //Добавить в метод имя инстанса у которой нажимаем кнопку увше
        CreateObjectInstancePage.checkValueInFieldIs("Test_country");
        CreateObjectInstancePage.checkValueInFieldIs("distributor_test_admin");
        CreateObjectInstancePage.checkValueInFieldIs("distributor_admin@gmail.com");
        CreateObjectInstancePage.checkRoleIs("Distributor Admin");
//        17) отсутствует - не реализовано
//        CreateObjectInstancePage.inputField("Name","distributor_test_admin_1");
//        ObjectInstancePage.clickButtonEdit();
//        ObjectInstancePage.checkTitleIsEditObject();
//        ObjectInstancePage.checkTitleIsDisplayed("User");
//        ObjectInstancePage.checkSuccessfulUpdete();
//        ObjectInstancePage.checkNameInstanceEnable("distributor_test_admin_1");


        Thread.sleep(3000);

    }
}
