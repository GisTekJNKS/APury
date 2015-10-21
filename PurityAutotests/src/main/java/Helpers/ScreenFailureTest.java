package Helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by Dmitry Makhankov on 17.10.2015.
 */
public class ScreenFailureTest extends TestListenerAdapter {

    public void onTestFailure (ITestResult result){
        super.onTestFailure(result);
        failureScreenShot();
    }

    @Attachment
    public static byte[] failureScreenShot() {
        return ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
