package ru.vkrepostcontest.service.authentication;

import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.vkrepostcontest.util.AppProps;

/**
 * Сервис для получения токена
 *
 * @author Roman
 * @since 0.1
 */
@Service
@DependsOn("appProps")
public class AuthentificationService {

    /**
     * Получение токена VK API
     * 
     * @return
     */
    public AccessToken createAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(AppProps.getAuthentificationUrl(),
            AppProps.getClientId(), AppProps.getClientSecret(), AppProps.getApiVersion());
        ResponseEntity<AccessToken> responseEntity = restTemplate.getForEntity(url,
            AccessToken.class);
        return responseEntity.getBody();
    }
}
