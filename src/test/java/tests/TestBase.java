package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.config.WebConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static tests.helpers.AllureAttachments.*;

public class TestBase {

    public static WebConfig webConfig = ConfigFactory.create(WebConfig.class);

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.browser = webConfig.browserName();
        Configuration.browserVersion = webConfig.browserVersion();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        if(webConfig.remote()) {
            String login = webConfig.selenideLogin();
            String password = webConfig.selenidePassword();
            String url = webConfig.selenideUrl();
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", login, password, url);
        }
    }

    @AfterEach
    void afterEach() {
        addScreenshotAs("Last screenshot");
        addPageSource();
        addBrowserConsoleLogs();

        if(webConfig.selenideUrl() != null) {
            addVideo();
        }

        closeWebDriver();
    }
}
