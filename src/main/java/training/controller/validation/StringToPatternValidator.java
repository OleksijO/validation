package training.controller.validation;

import java.util.regex.Pattern;

/**
 * This class provides functionality to validate string values to specified compiled patterns
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class StringToPatternValidator extends AbstractValidator {
    public static final String STRING_DO_NOT_MATHES_PATTERN = "Validation error: string value do not matches pattern. ";
    public static final String STRING_IS_NULL = "Validation error: string value is NULL. ";
    public static final String PATTERN_IS_NULL = "Validation error: pattern is NULL. ";
    /**
     * Validates string value if it matches specified compiled pattern
     *
     * @param stringToValidate the string value to be valideted
     * @param pattern the compiled pattern reference
     * @return true if stringToValidate matches pattern, false in othe case
     */
    public boolean validate(String stringToValidate, Pattern pattern) {
        if (stringToValidate==null) {
            errorMessage = STRING_IS_NULL;
            return false;
        }
        if (pattern==null) {
            errorMessage = PATTERN_IS_NULL;
            return false;
        }
        if (pattern.matcher(stringToValidate).matches()) {
            return true;
        }
        errorMessage = STRING_DO_NOT_MATHES_PATTERN;
        return false;
    }

}
