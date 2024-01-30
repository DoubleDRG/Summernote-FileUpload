package david.summernoteEditor.service;

import david.summernoteEditor.domain.Post;
import david.summernoteEditor.domain.form.PostForm;
import david.summernoteEditor.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class PostService
{
    private final PostRepository postRepository;

    public Post save(PostForm form)
    {
        String title = form.getTitle();
        String content = form.getContent();

        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post);
    }

    public Post findById(Long postId)
    {
        return postRepository.findById(postId);
    }
}
