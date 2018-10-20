package blog.app.Blog.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//tutuaj dodaje do wszystkich pól
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post {

//    id, title, content

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public String content;

    //dodaje dodatkowe wiersze z logami zaimplementowane w AuditEntity
    @Embedded
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> comments = new HashSet<>();


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);
    }
}
