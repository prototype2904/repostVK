package ru.vkrepostcontest.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Параметры приложения
 * @author Roman
 * @since 0.1
 */
@Component
public class AppProps {

    /**
     * урл авторизации со стороны сервера
     */
    private static String authentificationUrl;

    /**
     * ид приложения
     */
    private static String clientId;

    /**
     * секертный пароль приложения
     */
    private static String clientSecret;

    /**
     * версия апи
     */
    private static String apiVersion;

    /**
     * начало урла любого метода
     */
    private static String methodUrl;

    public static String getAuthentificationUrl() {
        return authentificationUrl;
    }

    @Value("${vk.auth-url}")
    private void setAuthentificationUrl(String authentificationUrl) {
        this.authentificationUrl = authentificationUrl;
    }

    public static String getClientId() {
        return clientId;
    }

    @Value("${vk.client-id}")
    private void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    @Value("${vk.client-secret}")
    private void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public static String getApiVersion() {
        return apiVersion;
    }

    @Value("${vk.api.version}")
    private void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public static String getMethodUrl() {
        return methodUrl;
    }

    @Value("${vk.api.method-url}")
    private void setMethodUrl(String methodUrl) {
        this.methodUrl = methodUrl;
    }
}
