package ru.vkrepostcontest.responseForm.newsfeed;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import ru.vkrepostcontest.responseForm.GroupResponseForm;
import ru.vkrepostcontest.responseForm.PostResponseForm;
import ru.vkrepostcontest.responseForm.ProfileResponseForm;

/**
 * Ответ на новости
 *
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class NewsfeedResponseForm {

    @JsonProperty("items")
    private List<PostResponseForm> posts;

    @JsonProperty("count")
    private String count;

    @JsonProperty("total_count")
    private String totalCount;

    @JsonProperty("profiles")
    private List<ProfileResponseForm> profiles;

    @JsonProperty("groups")
    private List<GroupResponseForm> groups;

    @JsonProperty("next_from")
    private String nextFrom;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public List<ProfileResponseForm> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileResponseForm> profiles) {
        this.profiles = profiles;
    }

    public List<GroupResponseForm> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupResponseForm> groups) {
        this.groups = groups;
    }

    public List<PostResponseForm> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponseForm> posts) {
        this.posts = posts;
    }

    public String getNextFrom() {
        return nextFrom;
    }

    public void setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
    }
}
