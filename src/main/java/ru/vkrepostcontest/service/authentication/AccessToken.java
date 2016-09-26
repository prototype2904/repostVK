package ru.vkrepostcontest.service.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Класс токена доступа к методам VK Api
 *
 * @author Roman
 * @since 0.1
 */
public class AccessToken {

    /**
     * строка токена
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * строка время жизни
     */
    @JsonProperty("expires_ in")
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
