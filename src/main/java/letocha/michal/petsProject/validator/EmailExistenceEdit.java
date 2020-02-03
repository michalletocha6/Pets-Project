package letocha.michal.petsProject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailExistenceEditValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExistenceEdit {
    String message() default "{emailExistence.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
