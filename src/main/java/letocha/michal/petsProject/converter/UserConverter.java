package letocha.michal.petsProject.converter;


import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.service.UserService;
import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, AppUser> {
    private final UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AppUser convert(String source) {
        return userService.getUserById(Long.valueOf(source));
    }

}
