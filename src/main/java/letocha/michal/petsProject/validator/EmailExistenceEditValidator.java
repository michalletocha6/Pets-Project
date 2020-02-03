package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.User;
import letocha.michal.petsProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistenceEditValidator implements ConstraintValidator<EmailExistenceEdit, String> {
    private final UserService userService;
    private final HttpServletRequest httpServletRequest;

    public EmailExistenceEditValidator(UserService userService, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User userFromSession = userService.getUserFromSession(httpServletRequest);
        User userByEmail = userService.getUserByEmail(value);
        if (value.equals(userFromSession.getEmail())) {
            return true;
        } else return userByEmail == null;
    }
}