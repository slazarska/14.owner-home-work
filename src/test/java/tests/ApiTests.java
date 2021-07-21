package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.config.ApiConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTests {

    public static ApiConfig apiConfig = ConfigFactory.create
            (ApiConfig.class, System.getProperties());

    @Test
    public void testApi(){
        System.out.println("url: " + apiConfig.getBaseUrl());
        System.out.println("token: " + apiConfig.getToken());
    }

//    @Test
//    void getTokenFromFile() {
//        assertThat("localhost")
//                .isEqualTo(apiConfig.getBaseUrl());
//        assertThat("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")
//                .isEqualTo(apiConfig.getToken());
//    }
//
//    @Test
//    void getTokenFromSystemProperties() {
//        final String expectedToken = "token23",
//                baseUrl = "localhost";
//
//        assertThat(baseUrl)
//                .isEqualTo(apiConfig.getBaseUrl());
//        assertThat(expectedToken)
//                .isEqualTo(apiConfig.getToken());
//    }
}
