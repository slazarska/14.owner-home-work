package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:run_configuration/${stage}.properties"
})
public interface WebConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("browser.remote.run")
    Boolean isRemote();

    //todo URL
    @Key("selenide.url")
    String selenideUrl();

    @Key("selenide.login")
    String getLogin();

    @Key("selenide.password")
    String getPassword();
}
