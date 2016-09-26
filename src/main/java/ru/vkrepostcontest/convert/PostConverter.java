package ru.vkrepostcontest.convert;

import org.springframework.stereotype.Component;
import ru.vkrepostcontest.domain.Post;
import ru.vkrepostcontest.responseForm.PostResponseForm;

import java.util.Date;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
@Component
public class PostConverter implements Converter<Post, PostResponseForm> {

    @Override
    public Post formToObject(PostResponseForm postResponseForm) {
        Post post = new Post();
        post.setOwnerId(postResponseForm.getOwnerId());
        post.setPostId(postResponseForm.getId().toString());
        return post;
    }

    @Override
    public PostResponseForm objectToForm(Post object) {
        return null;
    }


    public Post formToObject(PostResponseForm postResponseForm, Date date) {
        Post post = formToObject(postResponseForm);
        post.setDate(date);
        return post;
    }
}
