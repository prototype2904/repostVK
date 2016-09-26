package ru.vkrepostcontest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import ru.vkrepostcontest.service.authentication.AccessToken;
import ru.vkrepostcontest.service.authentication.AuthentificationService;

/**
 * Created by Roman on 02.09.2016.
 */
@Configuration
public class Config {

    @Autowired
    private AuthentificationService authentificationService;

    /**
     * Бин токена VK API
     *
     * @return
     */
    @Bean
    public AccessToken getAccessToken() {
        return authentificationService.createAccessToken();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
