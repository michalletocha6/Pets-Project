package letocha.michal.petsProject.converter;


import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, User> {
    private final UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(String source) {
        return userService.getUserById(Long.valueOf(source));
    }

}
