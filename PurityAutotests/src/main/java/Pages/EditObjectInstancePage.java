package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitry Makhankov on 19.10.2015.
 */
public class EditObjectInstancePage extends BasePage {


    private static final By EDIT_OBJECT_BUTTON = By.cssSelector(".btn.btn-primary.btn-xs");
    private static final By EDIT_BUTTON = By.xpath("//button[contains(text(),'Edit')]");
    private static final By DELETE_BUTTON = By.cssSelector(".btn.btn-danger.btn-xs.btn-delete");
    private static final By TITLE = By.tagName("h2");
    private static final By MESSAGE_AFTER_ACTION = By.id("w0");


    public enum ErrorMessageEditObjPage{
        WrongIntegerData,
        WrongStringData,
        WrongEmail,
    }

    public static void clickButtonEditObject(){
        $(EDIT_OBJECT_BUTTON).click();
    }

    public static void clickButtonEdit(){
        $(EDIT_BUTTON).waitUntil(visible,5000).click();
    }

    public static void checkSuccessfulUpdete(){
        assertTrue($("#w0").waitUntil(visible, 5000).getText().contains("Well done! You successfully updated Object of entity"));
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
        assertTrue($(MESSAGE_AFTER_ACTION).waitUntil(visible, 10000).getText().contains("Well done! You successfully deleted Object of entity"));
    }


    public static void checkTitleIsDisplayed(){
        assertTrue($(TITLE).waitUntil(visible, 10000).getText().startsWith("Edit"));
    }

}
