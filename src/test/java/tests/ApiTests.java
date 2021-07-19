package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.config.ApiConfig;

public class ApiTests {

    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class);

    @Test
    public void testApi(){
        System.out.println("url: " + apiConfig.url());
        System.out.println("token: " + apiConfig.token());
    }
}
