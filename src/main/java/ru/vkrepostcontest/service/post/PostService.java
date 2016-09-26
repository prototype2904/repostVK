package ru.vkrepostcontest.service.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vkrepostcontest.domain.Post;
import ru.vkrepostcontest.domain.PostRepository;

import java.util.List;

/**
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
@Service
public class PostService {

    private final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        Post save = postRepository.save(post);
//        logger.info("Сохранение поста {}_{}", post.getOwnerId(), post
//                .getPostId());
        return save;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public boolean isExist(Post post){
        return postRepository.isExistOneByOwnerIdAndPostId(post.getOwnerId(), post.getPostId());
    }
}
