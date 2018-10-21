package blog.app.Blog.services;


//import blog.app.Blog.models.dto.UserDto;
//import blog.app.Blog.models.entities.User;
//import blog.app.Blog.repositories.UserRepository;
//import lombok.Getter;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserSessionService {
//
//    @Getter
//    private boolean logged;
//    @Getter
//    private boolean userDto;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    public boolean loginUser(String userName, String password) {
//        Optional<User> optionalUser = userRepository.findByUserName(userName);
//        if (!optionalUser.isPresent()) {
//            return false;
//        }
//
//        User user = optionalUser.get();
//
//        if (!user.getPassword().equals(password)) {
//            return false;
//        }
//
//        userDto = modelMapper.map(user, UserDto.class);
//
//        logged = true;
//
//        return logged;
//
//    }
//}

import blog.app.Blog.models.dto.UserDto;
import blog.app.Blog.models.entities.User;
import blog.app.Blog.repositories.UserRepository;
import lombok.Getter;

import lombok.ToString;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.context.annotation.ScopedProxyMode;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSessionService {
    @Getter
    private boolean logged;
    @Getter
    private UserDto userDto;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public boolean loginUser(String userName, String password) {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (!optionalUser.isPresent()) {
            return false;
        }
        User user = optionalUser.get();
        if (!user.getPassword().equals(password)) {
            return false;
        }
        userDto = modelMapper.map(user, UserDto.class);
        logged = true;
        return logged;
    }

    public boolean logout() {
        logged = false;
        userDto = null;
        return true;
    }

}

