package DreamDiary;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

@Component //used for validating password from signup form
public class PasswordValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","", "Please select a password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm","", "Please confirm your password");
        User user = (User) obj;
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "","Your passwords don't match");
        }
    }
}

