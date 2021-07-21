package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.config.ApiConfig;

public class ApiTests {

    public static ApiConfig apiConfig = ConfigFactory.create
            (ApiConfig.class, System.getProperties());

    @Test
    public void testApi() {
        System.out.println("url: " + apiConfig.getBaseUrl());
        System.out.println("token: " + apiConfig.getToken());
    }
}
