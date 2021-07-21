package tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:api.properties",
})
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface ApiConfig extends Config {

    @Key("base.url")
    String getBaseUrl();

    @Key("token")
    String getToken();
}
