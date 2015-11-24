package Pages;

import Base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

/**
 * Created by John on 19.11.2015.
 */
public class EditPermissionPage extends BasePage {

    private static final By TITLE = By.tagName("h2");
    private static final By EDIT_BUTTON = By.cssSelector(".btn.btn-primary");

    public enum checkBox {
        Create,
        Modify,
        Delete,
    }

    public static void checkTitleIsEditRole() {
        $(TITLE).waitUntil(visible, 6000).shouldHave(text("Edit role"));
    }

    public static void tapCheckbox(String nameOfType, checkBox box,boolean value) {
        SelenideElement table = $("tbody");
        SelenideElement row = table.$$(By.tagName("tr")).get(getNumberOfRow(nameOfType));
        switch (box) {
            case Create:
                row.$(By.cssSelector("input[data-action='create']")).setSelected(value);
                break;
            case Modify:
                row.$(By.cssSelector("input[data-action='edit']")).setSelected(value);
                break;
            case Delete:
                row.$(By.cssSelector("input[data-action='delete']")).setSelected(value);
                break;
        }
    }

    public static void checkValueOfCheckbox(String nameOfType, checkBox box,boolean value) {
        SelenideElement table = $("tbody");
        SelenideElement row = table.$$(By.tagName("tr")).get(getNumberOfRow(nameOfType));
        switch (box) {
            case Create:
                Assert.assertEquals(row.$(By.cssSelector("input[data-action='create']")).isSelected(),value);
                break;
            case Modify:
                Assert.assertEquals(row.$(By.cssSelector("input[data-action='edit']")).isSelected(), value);
                break;
            case Delete:
                Assert.assertEquals(row.$(By.cssSelector("input[data-action='delete']")).isSelected(), value);
                break;
        }
    }

    public static void clickButtonEdit(){
        $(EDIT_BUTTON).click();
        assertTrue($("#w0").waitUntil(visible, 6000).getText().contains("Well done! You successfully updated role"));
    }


}
