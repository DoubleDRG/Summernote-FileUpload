package david.summernoteEditor.domain.form;

import lombok.Data;

@Data
public class PostForm
{
    private String title;
    private String content;

    public PostForm(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
