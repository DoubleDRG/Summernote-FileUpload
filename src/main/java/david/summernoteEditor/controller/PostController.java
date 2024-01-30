package david.summernoteEditor.controller;

import david.summernoteEditor.domain.Post;
import david.summernoteEditor.domain.form.PostForm;
import david.summernoteEditor.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PostController
{
    private final PostService postService;

    @GetMapping("/")
    public String home()
    {
        return "redirect:/posts/new";
    }

    @GetMapping("/posts/new")
    public String postForm()
    {
        return "post-form";
    }

    @PostMapping("/posts/new")
    public String postSave(@ModelAttribute PostForm form)
    {
        Post post = postService.save(form);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/{postId}")
    public String postDetail(@PathVariable Long postId, Model model)
    {
        Post post = postService.findById(postId);
        model.addAttribute("post", post);
        return "/post-view";
    }
}
