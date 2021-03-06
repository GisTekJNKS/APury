package Pages;

import Base.BasePage;
import Helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class ObjectInstancePage extends BasePage {


    private static final By EDIT_OBJECT_BUTTON = By.cssSelector(".btn.btn-primary.btn-xs");
    private static final By EDIT_BUTTON = By.xpath("//button[contains(text(),'Edit')]");
    private static final By DELETE_BUTTON = By.cssSelector(".btn.btn-danger.btn-xs.btn-delete");
    private static final By TITLE_LIST = By.xpath("//h2[contains(text(),'List of objects')]");
    private static final By TITLE_EDIT = By.xpath("//h2[contains(text(),'Edit object')]");
    private static final By MESSAGE_AFTER_ACTION = By.id("w0");
    private static final By CREATE_NEW_BUTTON = By.xpath("//a[contains(text(),'Create new')]");


    public enum ErrorMessageEditObjPage{
        WrongIntegerData,
        WrongStringData,
        WrongEmail,
    }

    public static void clickButtonEditObject(){
        $(EDIT_OBJECT_BUTTON).waitUntil(visible,5000).click();
    }

    public static void clickButtonEdit(){
        $(EDIT_BUTTON).waitUntil(visible,5000).click();
    }

    public static void checkSuccessfulUpdete(){
        assertTrue($("#w0").waitUntil(visible, 10000).getText().contains("Well done! You successfully updated Object of entity"));
    }

    public static void checkErrorMessage(ErrorMessageEditObjPage message,String fieldName){
        switch (message){
            case WrongIntegerData:$(By.xpath("//div[text()='"+fieldName+" must be no greater than 1000.']")).waitUntil(visible, 5000);
                break;
            case WrongStringData:$(By.xpath("//div[text()='"+fieldName+" should contain at most 1,000 characters.']")).waitUntil(visible, 5000);
                break;
            case WrongEmail:$(By.xpath("//div[text()='"+fieldName+" is not a valid email address.']")).waitUntil(visible, 5000);
                break;
        }
    }

    public static void clickButtonDelete(){
        $(DELETE_BUTTON).click();
        org.openqa.selenium.Alert alert = getWebDriver().switchTo().alert();
        alert.accept();
        Waiter.waitForJquery(10000);
        assertTrue($(MESSAGE_AFTER_ACTION).waitUntil(visible, 15000).getText().contains("Well done! You successfully deleted Object of entity"));
    }


    public static void checkTitleIsListOfObjects(String name){
        assertTrue($(TITLE_LIST).waitUntil(visible, 10000).getText().contains("List of objects (\""+name+"\" type)"));
    }

    public static void checkTitleIsEditObject(){
        assertTrue($(TITLE_EDIT).waitUntil(visible, 10000).getText().contains("Edit object"));
    }

    public static void checkPathOfCountryInstance(){
        $(By.xpath("//td[text()='Root -> country_test -> distributor_test']")).shouldBe(visible);
    }

    public static void checkPathOfDistributorInstance(){
        $(By.xpath("//td[text()='Root -> country_test -> distributor_test -> Test_country']")).shouldBe(visible);
    }

    public static void checkNameInstanceEnable(String name){
        $(By.xpath("//td[text()='"+name+"']")).shouldBe(visible);
    }

    public static void checkControlButtonsEnable(){
        $(EDIT_OBJECT_BUTTON).shouldBe(visible);
        $(DELETE_BUTTON).shouldBe(visible);
    }

    public static void clickButtonCreateNew (){
        $(CREATE_NEW_BUTTON).click();
    }

    public static void checkCreateNewIsAvailable(boolean condition){
        assertEquals($(CREATE_NEW_BUTTON).isDisplayed(),condition);

    }

    public static void checkEditIsAvailable(boolean condition){
        assertEquals($(EDIT_OBJECT_BUTTON).isDisplayed(),condition);

    }

    public static void checkDeleteIsAvailable(boolean condition){
        assertEquals($(DELETE_BUTTON).isDisplayed(),condition);

    }


}
