package training.controller.validation;

import java.util.regex.Pattern;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class StringToPatternValidator extends AbstractValidator {

    public boolean validate(String stringToValidate, Pattern pattern) {
        if (pattern.matcher(stringToValidate).matches()) {
            return true;
        }
        errorMessage = STRING_DO_NOT_MATHES_PATTERN;
        return false;
    }

}
