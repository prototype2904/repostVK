package ru.vkrepostcontest.responseForm;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ответ Группа
 *
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class GroupResponseForm extends ResponseForm {

    /**
     * Название
     */
    @JsonProperty("name")
    private String name;

    /**
     * Название в урле
     */
    @JsonProperty("screen_name")
    private String screenName;

    /**
     * Закрыта или нет
     */
    @JsonProperty("is_closed")
    private boolean isClosed;

    /**
     * Тип: паблик, группа...
     */
    @JsonProperty("type")
    private String type;

    /**
     * фото 50х50 пикс
     */
    @JsonProperty("photo_50")
    private String urlPhoto50;

    /**
     * фото 100х100 пикс
     */
    @JsonProperty("photo_100")
    private String urlPhoto100;

    /**
     * фото 200х200 пикс
     */
    @JsonProperty("photo_200")
    private String urlPhoto200;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlPhoto50() {
        return urlPhoto50;
    }

    public void setUrlPhoto50(String urlPhoto50) {
        this.urlPhoto50 = urlPhoto50;
    }

    public String getUrlPhoto100() {
        return urlPhoto100;
    }

    public void setUrlPhoto100(String urlPhoto100) {
        this.urlPhoto100 = urlPhoto100;
    }

    public String getUrlPhoto200() {
        return urlPhoto200;
    }

    public void setUrlPhoto200(String urlPhoto200) {
        this.urlPhoto200 = urlPhoto200;
    }
}
