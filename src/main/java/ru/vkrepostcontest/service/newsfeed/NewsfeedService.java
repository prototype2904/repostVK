package ru.vkrepostcontest.service.newsfeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vkrepostcontest.convert.PostConverter;
import ru.vkrepostcontest.domain.Post;
import ru.vkrepostcontest.responseForm.PostResponseForm;
import ru.vkrepostcontest.responseForm.newsfeed.NewsfeedResponseForm;
import ru.vkrepostcontest.resstrequest.NewsfeedRestRequest;
import ru.vkrepostcontest.service.post.PostService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Roman
 * @since 0.1
 */
@Service
public class NewsfeedService {

    @Autowired
    private NewsfeedRestRequest newsfeedRestRequest;

    @Autowired
    private PostConverter postConverter;

    @Autowired
    private PostService postService;

    /**
     * получить новые посты из контакта
     *
     * @param search
     * @param nextFrom
     * @return
     */
    public NewsfeedResponseForm getNewPostsFromVK(String search, String nextFrom){
        NewsfeedResponseForm newsfeedResponseForm = newsfeedRestRequest.searchByString(search, nextFrom);
        List<PostResponseForm> posts = newsfeedResponseForm.getPosts()
                .stream()
                // фильтрация, то что это пост, то что это не копия, то что это пост группы
                .filter(postResponseForm -> postResponseForm.getPostType().equals("post")
                        && postResponseForm.getOwnerId().equals(postResponseForm.getFromId())
                        && postResponseForm.getOwnerId().contains("-"))
                //узнать, сохранен ли этот пост уже
                .filter(this::isNotExistPost).collect(Collectors.toList());
        newsfeedResponseForm.setPosts(posts);
        return newsfeedResponseForm;
    }

    private boolean isNotExistPost(PostResponseForm postResponseForm){
        return !postService.isExist(postConverter.formToObject(postResponseForm));
    }
}
