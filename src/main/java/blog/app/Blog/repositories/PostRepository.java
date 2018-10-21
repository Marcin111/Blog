package blog.app.Blog.repositories;

import blog.app.Blog.models.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  //  Post deleteById (Long id);



}
