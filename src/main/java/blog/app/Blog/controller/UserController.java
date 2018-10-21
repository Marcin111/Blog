package blog.app.Blog.controller;

import blog.app.Blog.repositories.UserRepository;
import blog.app.Blog.services.UserSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //@Autowired
    private UserRepository userRepository;
    //@Autowired
    private UserSessionService userSessionService;
    //@Autowired
    private ModelMapper modelMapper;

    //public UserController(UserRepository);

    @Autowired
    public UserController(UserRepository userRepository, UserSessionService userSessionService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
        this.modelMapper = modelMapper;
    }
}
