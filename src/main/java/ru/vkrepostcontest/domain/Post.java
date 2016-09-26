package ru.vkrepostcontest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
@Entity
@Table(name = "post", uniqueConstraints = @UniqueConstraint(columnNames = {"owner_id", "post_id"}))
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "owner_id")
    private String ownerId;

    @Column(name = "post_id")
    private String postId;

    @Column(name = "date")
    private Date date;

    @Column(name = "available")
    private boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
