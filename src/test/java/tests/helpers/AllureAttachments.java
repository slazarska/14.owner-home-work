package tests.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AllureAttachments {

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String addMessage(String attachName, String text) {
        return text;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] addPageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] addScreenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void addVideo() {
        //String url = TestBase.webConfig.selenideUrl();
        String selenoidUrl = "http://46.101.118.177:4444";
        try {
            URL videoUrl = new URL(selenoidUrl + "/video/" + getSessionId() + ".mp4");
            InputStream is = null;
            Thread.sleep(1000);
            for (int i = 0; i < 10; i++) {
                try {
                    is = videoUrl.openStream();
                    i = 10;
                } catch (FileNotFoundException e) {
                    Thread.sleep(1000);
                }
            }
            Allure.addAttachment("Video", "video/mp4", is, "mp4");
        } catch (Exception e) {
            System.out.println("attachAllureVideo");
            e.printStackTrace();
        }
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

    public static void addBrowserConsoleLogs() {
        AllureAttachments.addMessage("Browser console logs", String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }
}
