package david.summernoteEditor.repository;

import david.summernoteEditor.domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MySqlPostRepositoryImpl implements PostRepository
{
    private final EntityManager entityManager;

    @Override
    public Post save(Post post)
    {
        entityManager.persist(post);
        return post;
    }

    @Override
    public Post findById(Long postId)
    {
        return entityManager.find(Post.class, postId);
    }
}
