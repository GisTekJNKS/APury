import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */

@Listeners(ScreenFailureTest.class)
public class Test1SuccessfulAuthorization extends BaseTest {


    @Test
    public void authorize(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("admin@gmail.com");
        LoginPage.inputPassword("admin");
        LoginPage.clickSignIn();
        MainPage.dashboardIsDisplayed();
    }
}
