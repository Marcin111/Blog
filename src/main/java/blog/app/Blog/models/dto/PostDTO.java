package blog.app.Blog.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//konstruktor bez argumentow
@NoArgsConstructor
//konstruktor z wszystkimi polami
@AllArgsConstructor
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;

}
