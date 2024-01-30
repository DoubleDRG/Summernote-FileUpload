package david.summernoteEditor.repository;

import david.summernoteEditor.domain.Post;

public interface PostRepository
{
    public Post save(Post post);

    public Post findById(Long postId);
}
