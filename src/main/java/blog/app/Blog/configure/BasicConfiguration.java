package blog.app.Blog.configure;

import blog.app.Blog.models.dto.PostDTO;
import blog.app.Blog.models.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BasicConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(pst -> pst.getUser().getId(), PostDTO::setIdOfUser)
                .addMapping(p -> p.getAudit() .getAdded(), PostDTO::setCreated);
    return modelMapper;
    }


//    @Bean
//    public ModelMapper modelMapper(){
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.createTypeMap(Post.class, PostDTO.class)
//                .addMapping(pst -> pst.getUser().getId(), PostDTO::setIdOfUser)
//                .addMapping(p -> p.getAudit().getAdded(), PostDTO::setCreated);
////        modelMapper.createTypeMap(Tag.class, TagDto.class)
////                .addMapping(t -> t.getAudit().getAdded(), TagDto::setCreated);
//        return modelMapper;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
