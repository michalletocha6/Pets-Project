package letocha.michal.pets_project.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailExistenceValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExistence {
    String message() default "{emailExistence.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
