package Pages;

import Base.BasePage;
import Helpers.Waiter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.*;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class ObjectEditorPage extends BasePage{
    private static final By TITLE = By.tagName("h2");
    private static final By CREATE_NEW_BUTTON = By.cssSelector(".btn.btn-primary.add-role-btn");
    private static final By NAME = By.id("objectslistform-entity_name");
    private static final By MACHINE_NAME= By.id("objectslistform-machine_name");
    private static final By ADD_OBJECT_FIELD_BUTTON= By.cssSelector("span[data-original-title='Add object field']");
    private static final By FIELD_NAME = By.id("fieldsform-caption");
    private static final By TYPE = By.id("fieldsform-obj_type");
    private static final By ADD_BUTTON= By.cssSelector(".btn.btn-primary.add-btn");
    private static final By CANCEL_BUTTON= By.cssSelector(".btn.btn-default.cansel-btn");
    private static final By CREATE_BUTTON= By.id("submit-object-form");
    private static final By DELETE_BUTTON=By.cssSelector(".btn.btn-danger");
//    private static final By =By.("");
//    private static final By =By.("");
//    private static final By =By.("");
//    private static final By =By.("");
//    private static final By =By.("");
//    private static final By =By.("");
//    private static final By =By.("");

    public enum Type{
        Choose,
        Integer,
        String,
        Boolean,
        Password,
        Email,
        Date,
        DateTime,
        Price
    }

    private static SelenideElement getProblemElem(By locator) { // ГРАБЛИ!!!!
        try {
            return $(locator);
        } catch (StaleElementReferenceException e) {
            return getProblemElem(locator);
        }
    }

    public static void checkTitleisDisplayed(){
        $(TITLE).waitUntil(visible, 6000).shouldHave(text("List of Object types"));
    }

    public static void clickButtonCreateNew (){
        $(CREATE_NEW_BUTTON).click();
        $(TITLE).shouldBe(visible).shouldHave(text("Create object type"));
    }

    public static void inputName(String name){
        $(NAME).sendKeys(name);
    }

    public static void inputMachineName(String machineName){
        $(MACHINE_NAME).sendKeys(machineName);
    }

    public static void clickButtonAddObjectFields(){
        actions().moveToElement($(ADD_OBJECT_FIELD_BUTTON).shouldBe(visible)).click().build().perform();
        Waiter.waitForJquery(10000);
        if ($(FIELD_NAME).is(not(visible)))
        {
            clickButtonAddObjectFields();
        }
        $(FIELD_NAME).waitUntil(exist, 5000);
    }

    public static void inputFieldName(String fieldName) {
        $(FIELD_NAME).waitUntil(exist,5000).click();
        $(FIELD_NAME).click();
        $(FIELD_NAME).clear();
        $(FIELD_NAME).sendKeys(fieldName);
        $("#pjax-widget").click();
        if($(By.cssSelector(".help-block.help-block-error")).is(visible)){
            inputFieldName(fieldName);
        }
    }



    public static void selectType(Type type){
        switch (type){
            case Choose:$(TYPE).selectOptionByValue("choose");
                break;
            case Integer:$(TYPE).selectOptionByValue("Integer");
                break;
            case String:$(TYPE).selectOptionByValue("String");
                break;
            case Boolean:$(TYPE).selectOptionByValue("Boolean");
                break;
            case Password:$(TYPE).selectOptionByValue("Password");
                break;
            case Email:$(TYPE).selectOptionByValue("Email");
                break;
            case Date:$(TYPE).selectOptionByValue("Date");
                break;
            case DateTime:$(TYPE).selectOptionByValue("DateTime");
                break;
            case Price:$(TYPE).selectOptionByValue("Float");
                break;
        }
    }

    public static void clickButtonAdd(){
        $(ADD_BUTTON).click();
        Waiter.waitForJquery(10000);
    }

    public static void clickButtonCancel(){
        $(CANCEL_BUTTON).click();
    }

    public static void clickButtonCreate(){
        $(CREATE_BUTTON).click();
        if ($(By.xpath("//h2[contains(text(),'Create object type')]")).exists()) {
            clickButtonCreate();
        }
        assertTrue($("#w0").waitUntil(visible, 20000).getText().contains("Well done! You successfully created entity"));
    }

    public static void clickButtonDelete(){
        $(DELETE_BUTTON).click();
    }

    public static void checkAddedObjectsFields(String fieldsName){
        $(By.xpath("//tr/td[text()='"+fieldsName+"']")).shouldBe(visible);
    }

    public static void checkAddedObject(String objectName){

        $(By.xpath("//tr/td[text()='"+objectName+"']")).waitUntil(visible, 15000);
    }

    public static void clickDeleteObject (String name){
        SelenideElement element = $$(By.tagName("tr")).get(getNumberOfRowg(name));
        element.$(".glyphicon.glyphicon-remove").click();
        assertTrue($("#w0").waitUntil(visible, 6000).getText().contains("Well done! You successfully deleted entity - " + name + ""));
    }

    private static int getNumberOfRowg(String name){
        ElementsCollection rows = $$(By.tagName("tr"));
        for (int i=0;i<rows.size();i++){
            rows.get(i).$(By.xpath("//td[contains(text(),'" + name + "')]")).should(exist);
            return i;
        }
        return Integer.parseInt(null);
    }



}
