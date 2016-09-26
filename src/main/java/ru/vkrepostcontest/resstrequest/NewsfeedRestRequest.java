package ru.vkrepostcontest.resstrequest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ru.vkrepostcontest.VkRestRequestService;
import ru.vkrepostcontest.convert.PostConverter;
import ru.vkrepostcontest.domain.Post;
import ru.vkrepostcontest.responseForm.PostResponseForm;
import ru.vkrepostcontest.responseForm.newsfeed.ListPostsResponseForm;
import ru.vkrepostcontest.responseForm.newsfeed.NewsfeedResponseForm;
import ru.vkrepostcontest.responseForm.newsfeed.SearchNewsfeedResponseForm;
import ru.vkrepostcontest.service.authentication.AccessToken;
import ru.vkrepostcontest.service.post.PostService;
import ru.vkrepostcontest.util.AppProps;
import ru.vkrepostcontest.util.MethodBuilder;

/**
 * @author Roman
 * @since 0.1
 */
@Component
public class NewsfeedRestRequest {

    /**
     * число записей
     */
    public static final Integer COUNT = 200;

    /**
     * указывается 1, если необходимо получить информацию о пользователе или группе
     */
    private final String EXTENDED = "1";

    /**
     * Число повторов
     */
    private final int NUMBER = 5;

    @Autowired
    private AccessToken accessToken;

    @Autowired
    private PostConverter postConverter;

    @Autowired
    private PostService postService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VkRestRequestService vkRestRequestService;


    public NewsfeedResponseForm searchByString(String searchString, String next) {
        SearchNewsfeedResponseForm searchNewsfeedResponseForm = new SearchNewsfeedResponseForm();

        vkRestRequestService.doRequest(() -> {
            String url = (next != null)
                ? MethodBuilder.create(AppProps.getMethodUrl())
                    .methodName("newsfeed.search").parameter("q", searchString)
                    .parameter("extended", EXTENDED).parameter("next_from", next)
                    .parameter("count", COUNT.toString()).version(AppProps
                            .getApiVersion()).build()
                : MethodBuilder.create(AppProps.getMethodUrl())
                    .methodName("newsfeed.search").parameter("q", searchString)
                    .parameter("extended", EXTENDED).parameter("count", COUNT.toString())
                    .version(AppProps.getApiVersion()).build();
            ResponseEntity<SearchNewsfeedResponseForm> forEntity = restTemplate
                .getForEntity(url, SearchNewsfeedResponseForm.class);
            searchNewsfeedResponseForm.setResponse(forEntity.getBody().getResponse());
        });
        return searchNewsfeedResponseForm.getResponse();
    }

    public List<PostResponseForm> getListById(List<Post> posts) {
        ListPostsResponseForm listPostsResponseForm = new ListPostsResponseForm();
        vkRestRequestService.doRequest(() -> {
            String url = MethodBuilder.create(AppProps.getMethodUrl())
                .methodName("wall.getById").parameter("posts", getPostsParameter(posts))
                .version(AppProps.getApiVersion()).build();
            ResponseEntity<ListPostsResponseForm> responseEntity = restTemplate
                .getForEntity(url, ListPostsResponseForm.class);
            listPostsResponseForm.setResponse(responseEntity.getBody().getResponse());
        });
        return listPostsResponseForm.getResponse();
    }

    private String getPostsParameter(List<Post> posts) {
        StringBuilder stringBuilder = new StringBuilder();
        posts.stream().forEach(post -> stringBuilder.append("-").append(post.getOwnerId())
            .append("_").append(post.getPostId()).append(","));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
