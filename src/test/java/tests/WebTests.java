package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class WebTests extends TestBase {

    @Test
    public void openGitHub() {
        System.out.println("browserName: " + webConfig.browserName());
        System.out.println("browserVersion: " + webConfig.browserVersion());
        System.out.println("remote: " + webConfig.remote());
        System.out.println("selenideUrl: " + webConfig.selenideUrl());
        System.out.println("selenideLogin: " + webConfig.selenideLogin());
        System.out.println("selenidePassword: " + webConfig.selenidePassword());

        open("https://github.com/");
        sleep(5000);
    }
}
