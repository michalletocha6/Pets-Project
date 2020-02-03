package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistenceValidator implements ConstraintValidator<UserExistence, Object> {
    private final UserService userService;

    public UserExistenceValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void initialize(UserExistence constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        User userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail == null) {
            return false;
        } else {
            return BCrypt.checkpw(user.getPassword(), userByEmail.getPassword());
        }
    }
}