package blog.app.Blog.controller;

import blog.app.Blog.models.entities.Post;
import blog.app.Blog.models.entities.PostComment;
import blog.app.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String postPage(Model model) {
        List<Post> postList = new ArrayList<>();
        Iterable<Post> postIterable = postRepository.findAll();

        for (Post post : postIterable) {
            postList.add(post);
        }
        model.addAttribute("posts", postList);
        //postRepository.findAll();
        return "posts";
    }

    @PostMapping("/addPost")
    public String addPost(
            @RequestParam(value = "title") String titleParam,
            @RequestParam(value = "content") String content) {
        Post post = new Post(titleParam, content);
        PostComment postComment = new PostComment();
        postComment.setComment(titleParam);
        post.addComment(postComment);
        postRepository.save(post);

        return "index";
    }

    @GetMapping("/addPost")
    //@ResponseBody
    public String addPosts() {
        return "addPost";
    }
}

