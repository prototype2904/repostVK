package ru.vkrepostcontest.responseForm;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ответ Профиль пользователя
 *
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class ProfileResponseForm extends ResponseForm {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("sex")
    private Boolean sex;

    @JsonProperty("screen_name")
    private String screenName;

    @JsonProperty("photo_50")
    private String urlPhoto50;

    @JsonProperty("photo_100")
    private String urlPhoto100;

    @JsonProperty("online")
    private Boolean online;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
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

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
