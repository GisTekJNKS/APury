import Base.BaseTest;
import Helpers.ScreenFailureTest;
import Pages.LoginPage;
import Pages.LoginPage.ErrorMessage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */

@Listeners(ScreenFailureTest.class)
public class Test2FailAuthorization extends BaseTest {

    @Test
    public static void authorizeWithEmptyFields(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("");
        LoginPage.inputLogin("");
        LoginPage.clickSignIn();
        LoginPage.checkErrorMessage(ErrorMessage.EmailCannotBeBlank);
        LoginPage.checkErrorMessage(ErrorMessage.PasswordCannotBeBlank);
    }

    @Test
    public static void authorizeWithIncorrectPassword(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("admin@gmail.com");
        LoginPage.inputPassword("adsfh");
        LoginPage.clickSignIn();
        LoginPage.checkErrorMessage(ErrorMessage.IncorrectUsernameOrPassword);
    }

    @Test
    public static void authorizeWithIncorrectEmail(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("admin@@gmail.com");
        LoginPage.inputPassword("sdg");
        LoginPage.checkErrorMessage(ErrorMessage.EmailIsNotAValidEmailAddress);
    }


}
