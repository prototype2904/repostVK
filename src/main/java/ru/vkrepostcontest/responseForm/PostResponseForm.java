package ru.vkrepostcontest.responseForm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class PostResponseForm extends ResponseForm {

    /**
     * идентификатор
     */
    @JsonProperty("id")
    private Long id;

    /**
     * дата публикации
     */
    @JsonProperty("date")
    private Date date;

    /**
     * идентификатор владельца стены, на которой размещена запись.
     * Если стена принадлежит сообществу, то данный параметр равен -gid (идентификатор сообщества со знаком минус);
     */
    @JsonProperty("owner_id")
    private String ownerId;

    /**
     * идентификатор автора записи
     */
    @JsonProperty("from_id")
    private String fromId;

    /**
     * содержит тип новости (post или copy)
     */
    @JsonProperty("post_type")
    private String postType;

    /**
     * текст записи
     */
    @JsonProperty("text")
    private String text;

    @JsonProperty("likes")
    private LikeResponseForm likes;

    @JsonProperty("reposts")
    private RepostResponseForm reposts;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCountLikes() {
        return likes.getCount();
    }

    public void setLikes(LikeResponseForm likes) {
        this.likes = likes;
    }

    public Long getCountReposts() {
        return reposts.getCount();
    }

    public void setReposts(RepostResponseForm reposts) {
        this.reposts = reposts;
    }

    public PostResponseForm removeMinus(){
        this.ownerId = this.ownerId.replace("-", "");
        this.fromId = this.fromId.replace("-", "");
        return this;
    }
}
