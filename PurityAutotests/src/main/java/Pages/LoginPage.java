package Pages;

import Base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class LoginPage extends BasePage {

    private static final By SHOW_LOGIN_FORM_BUTTON = By.id("show-login-form-btn");
    private static final By LOGIN_FIELD = By.id("loginform-email");
    private static final By PASSWORD_FIELD = By.id("loginform-password");
    private static final By SIGN_IN_BUTTON = By.cssSelector(".btn.btn-primary.sign-btn");
    public enum ErrorMessage{
        EmailCannotBeBlank,
        PasswordCannotBeBlank,
        IncorrectUsernameOrPassword,
        EmailIsNotAValidEmailAddress
    }

    private static final By ERROR_MESSAGE_BLANK_EMAIL = By.xpath("//p[text()='Email cannot be blank.']");
    private static final By ERROR_MESSAGE_BLANK_PASSWORD = By.xpath("//p[text()='Password cannot be blank.']");
    private static final By ERROR_MESSAGE_INCORRECT_DATA = By.xpath("//p[text()='Incorrect username or password.']");
    private static final By ERROR_MESSAGE_INVALID_EMAIL = By.xpath("//p[contains(text(),'Email is not a valid email address.')]");

    public static void showLoginForm(){
        $(SHOW_LOGIN_FORM_BUTTON).click();
        $(LOGIN_FIELD).shouldBe(visible);
        $(PASSWORD_FIELD).shouldBe(visible);
        $(SIGN_IN_BUTTON).shouldBe(visible);
    }

    public static void inputLogin(String login){
        $(LOGIN_FIELD).sendKeys(login);
    }

    public static void inputPassword(String password){
        $(PASSWORD_FIELD).sendKeys(password);
    }

    public static void clickSignIn(){
        $(SIGN_IN_BUTTON).click();
    }

    public static void checkErrorMessage(ErrorMessage message){
        switch (message){
            case EmailCannotBeBlank:$(ERROR_MESSAGE_BLANK_EMAIL).waitUntil(visible, 5000);
                break;
            case PasswordCannotBeBlank:$(ERROR_MESSAGE_BLANK_PASSWORD).waitUntil(visible, 5000);
                break;
            case IncorrectUsernameOrPassword:$(ERROR_MESSAGE_INCORRECT_DATA).waitUntil(visible, 5000);
                break;
            case EmailIsNotAValidEmailAddress:$(ERROR_MESSAGE_INVALID_EMAIL).waitUntil(visible, 5000);
                break;
        }
    }

    public static void authorizeAsAdmin(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("admin@gmail.com");
        LoginPage.inputPassword("admin");
        LoginPage.clickSignIn();
        MainPage.dashboardIsDisplayed();
    }

    public static void authorizeAsCountryAdmin(){
        LoginPage.showLoginForm();
        LoginPage.inputLogin("country_test_admin@gmail.com");
        LoginPage.inputPassword("country");
        LoginPage.clickSignIn();
        MainPage.dashboardIsDisplayed();
    }


}
