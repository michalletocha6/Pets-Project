package letocha.michal.petsProject.validator;

import letocha.michal.petsProject.entity.AppUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, AppUser> {

    @Override
    public boolean isValid(AppUser appUser, ConstraintValidatorContext context) {
        return appUser.getPassword().equals(appUser.getRepassword());
    }
}
