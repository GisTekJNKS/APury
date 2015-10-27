package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.*;

/**
 * Created by John on 19.10.2015.
 */
public class CreateObjectInstancePage extends BasePage {

    private static final By CHOOSE_THE_PARENT = By.id("object-parent");
    private static final By ROOT = By.className("jstree-anchor");
    private static final By TITLE = By.tagName("h2");
    private static final By CREATE_BUTTON = By.xpath("//button[text()='Create']");



//    private static final By STRING_FIELD = By.id("object-string");
//    private static final By BOOLEAN_FIELD = By.id("object-string");
//    private static final By PASSWORD_FIELD = By.id("object-string");
//    private static final By EMAIL_FIELD = By.id("object-string");
//    private static final By DATE_FIELD = By.id("object-string");
//    private static final By DATETIME_FIELD = By.id("object-string");
//    private static final By PRICE_FIELD = By.id("object-string");


    public static void chooseRoot(){
        $(CHOOSE_THE_PARENT).click();
        $(ROOT).waitUntil(visible,5000).click();
        $(TITLE).click();
    }

    public static void inputField(ObjectEditorPage.Type fieldsType,String value){
        switch (fieldsType){
            case Integer:
                $(By.cssSelector("input[placeholder='Enter Integer']")).clear();
                $(By.cssSelector("input[placeholder='Enter Integer']")).sendKeys(value);
                $(TITLE).click();
                break;
            case String:
                $(By.cssSelector("input[placeholder='Enter String']")).clear();
                $(By.cssSelector("input[placeholder='Enter String']")).sendKeys(value);
                $(TITLE).click();
                break;
            case Boolean:
                $(By.cssSelector("input[type='checkbox']")).click();
                break;
            case Password:
                $(By.cssSelector("input[placeholder='Enter Password']")).clear();
                $(By.cssSelector("input[placeholder='Enter Password']")).sendKeys(value);
                $(TITLE).click();
                break;
            case Email:
                $(By.cssSelector("input[placeholder='Enter Email']")).clear();
                $(By.cssSelector("input[placeholder='Enter Email']")).sendKeys(value);
                $(TITLE).click();
                break;
            case Date:
                $(By.cssSelector("input[placeholder='Choose Date']")).click();
                $$(By.xpath("//td[text()='"+value+"']")).get(1).click();
                break;
            case DateTime:
                $(By.cssSelector("input[placeholder='Choose DateTime']")).click();
                $(By.xpath("//td[text()='" + value.substring(0, value.indexOf(' ')) + "']")).click();
                $(By.xpath("//span[text()='"+value.substring(value.indexOf(' ')+1)+"']")).waitUntil(visible,5000).click();
                break;
            case Price:
                $(By.cssSelector("input[placeholder='Enter Price']")).clear();
                $(By.cssSelector("input[placeholder='Enter Price']")).sendKeys(value);
                $(TITLE).click();
                break;
        }
//        $(By.id("object-" + fieldName.toLowerCase())).clear();
//        $(By.id("object-" + fieldName.toLowerCase())).sendKeys(value);
//        $(TITLE).click();
    }

    public static void clickButtonCreate (){
        $(CREATE_BUTTON).click();
        assertTrue($("#w0").waitUntil(visible, 5000).getText().contains("Well done! You successfully created Object of entity"));
    }

    public static void checkTitleIsDisplayed(){
        assertTrue($(TITLE).waitUntil(visible, 5000).getText().startsWith("Create new"));
    }

}
