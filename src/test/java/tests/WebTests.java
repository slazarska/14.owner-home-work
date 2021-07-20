package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.config.WebConfig;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTests extends TestBase {

    private WebConfig webConfig = ConfigFactory.create(WebConfig.class,
            System.getProperties());

    @Test
    public void openGitHub() {
        System.out.println("browserName: " + webConfig.getBrowserName());
        System.out.println("browserVersion: " + webConfig.getBrowserVersion());
        System.out.println("remote: " + webConfig.isRemote());
        System.out.println("selenideUrl: " + webConfig.selenideUrl());
        System.out.println("selenideLogin: " + webConfig.getLogin());
        System.out.println("selenidePassword: " + webConfig.getPassword());

        open("https://github.com/");
        sleep(5000);
    }

//    @Test
//    void runWithLocalConfigFile() {
//
//        assertThat("chrome")
//                .isEqualTo(webConfig.getBrowserName());
//        assertThat("91.0")
//                .isEqualTo(webConfig.getBrowserVersion());
//        assertThat(false)
//                .isEqualTo(webConfig.isRemote());
//    }
//
//
//    @Test
//    void runWithRemoteConfigFile() {
//
//        assertThat("chrome")
//                .isEqualTo(webConfig.getBrowserName());
//        assertThat("91.0")
//                .isEqualTo(webConfig.getBrowserVersion());
//        assertThat(true)
//                .isEqualTo(webConfig.isRemote());
//    }
}
