package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.config.WebConfig;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTests extends TestBase {

    private WebConfig webConfig = ConfigFactory.create(WebConfig.class,
            System.getProperties());

    @Test
    public void openGithub() {
        open("https://github.com/");
        System.out.println("browserName: " + webConfig.getBrowserName());
        System.out.println("browserVersion: " + webConfig.getBrowserVersion());
        System.out.println("remote: " + webConfig.isRemote());
        System.out.println("selenideUrl: " + webConfig.selenideUrl());
        System.out.println("selenideLogin: " + webConfig.getLogin());
        System.out.println("selenidePassword: " + webConfig.getPassword());
    }

    @Test
    void checkWebConfig() {
        assertThat("chrome")
                .isEqualTo(webConfig.getBrowserName());
        assertThat("91.0")
                .isEqualTo(webConfig.getBrowserVersion());
        if (webConfig.isRemote() == false) {
            assertThat(false)
                    .isEqualTo(webConfig.isRemote());
        } else {
            assertThat(true)
                    .isEqualTo(webConfig.isRemote());
        }
    }
}
