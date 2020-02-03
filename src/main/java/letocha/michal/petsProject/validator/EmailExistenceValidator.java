package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailExistenceValidator implements ConstraintValidator<EmailExistence, String> {
    private final UserService userService;

    public EmailExistenceValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userService.getUserByEmail(value) == null;
    }
}