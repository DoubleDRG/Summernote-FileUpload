package david.summernoteEditor.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length=200000)
    private String content;

    protected Post()
    {
    }

    @Builder
    public Post(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
