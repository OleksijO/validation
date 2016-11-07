package training.controller.validation;

import java.util.regex.Pattern;

/**
 * This class provides functionality to validate string values to specified compiled patterns
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class StringToPatternValidator extends AbstractValidator {

    /**
     * Validates string value if it matches specified compiled pattern
     *
     * @param stringToValidate the string value to be valideted
     * @param pattern the compiled pattern reference
     * @return true if stringToValidate matches pattern, false in othe case
     */
    public boolean validate(String stringToValidate, Pattern pattern) {
        if (pattern.matcher(stringToValidate).matches()) {
            return true;
        }
        errorMessage = STRING_DO_NOT_MATHES_PATTERN;
        return false;
    }

}
