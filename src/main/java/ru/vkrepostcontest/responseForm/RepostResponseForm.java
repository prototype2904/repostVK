package ru.vkrepostcontest.responseForm;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public class RepostResponseForm {
    @JsonProperty("count")
    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
