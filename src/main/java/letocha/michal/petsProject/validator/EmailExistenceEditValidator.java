package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.AppUser;
import letocha.michal.petsProject.service.UserService;
import org.springframework.security.core.Authentication;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistenceEditValidator implements ConstraintValidator<EmailExistenceEdit, String> {
    private final UserService userService;

    public EmailExistenceEditValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        AppUser userFromContext = userService.getUserFromContext();
        AppUser appUserByEmail = userService.getUserByEmail(value);
        if (value.equals(userFromContext.getEmail())) {
            return true;
        } else return appUserByEmail == null;
    }
}