package letocha.michal.petsProject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserExistenceValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExistence {

    String message() default "{userExistence.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
