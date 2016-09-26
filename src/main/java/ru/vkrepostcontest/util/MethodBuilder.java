package ru.vkrepostcontest.util;

import org.springframework.util.StringUtils;

/**
 * Класс для создания URL метода для GET запроса
 *
 * @author Roman
 * @since 0.1
 */
public class MethodBuilder {

    /**
     * URL метод
     */
    private String url;

    /**
     * номер версии
     */
    private String version;

    /**
     * токен доступа
     */
    private String accessToken;

    /**
     * строка параметров
     */
    private String parameters;

    /**
     * название метода
     */
    private String methodName;

    private MethodBuilder(String url) {
        this.url = url;
    }

    public static MethodBuilder create(String url){
        return new MethodBuilder(url);
    }

    public MethodBuilder methodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public MethodBuilder version(String version) {
        this.version = version;
        return this;
    }

    public MethodBuilder accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public MethodBuilder parameter(String parameter, String value) {
        if (!StringUtils.isEmpty(parameters)) {
            parameters += "&";
        } else {
            parameters = new String();
        }
        parameters += parameter + "=" + value;
        return this;
    }

    public String build() {
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(methodName)) {
            throw new NullPointerException(
                "Значение URL или метода должены быть не null и не пустыми.");
        }
        boolean flagFirstParameter = true;
        StringBuilder stringBuilder = new StringBuilder(url).append(methodName)
            .append("?");
        if (!StringUtils.isEmpty(parameters)) {
            stringBuilder.append(parameters);
            flagFirstParameter = false;
        }
        if (!StringUtils.isEmpty(this.accessToken)) {
            if (!flagFirstParameter) {
                stringBuilder.append("&");
                flagFirstParameter = false;
            }
            stringBuilder.append("access_token=").append(accessToken);
        }
        if (!StringUtils.isEmpty(this.version)) {
            if (!flagFirstParameter) {
                stringBuilder.append("&");
                flagFirstParameter = false;
            }
            stringBuilder.append("v=").append(this.version);
        }
        return stringBuilder.toString();
    }
}
