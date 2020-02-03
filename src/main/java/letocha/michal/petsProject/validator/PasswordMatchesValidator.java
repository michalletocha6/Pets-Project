package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        User user = (User) value;

        return user.getPassword().equals(user.getRepassword());
    }
}
