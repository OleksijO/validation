package training.controller.validation;

/**
 * This class is used as a factory of different validators.
 *
 * @author oleksij.onysymchuk@gmail
 * @version 7 NOV 2016
 */
public class ValidatorFactory {


    /**
     * Initializes and returns instance of StringToPatternValidator
     *
     * @return instance of StringToPatternValidator
     */
    public static StringToPatternValidator getStringToPatternValidator() {
        return new StringToPatternValidator();
    }

    /**
     * Initializes and returns instance of IntInRangeValidator
     *
     * @param min lower included bound of validation range
     * @param max upper included bound of validation range
     * @return instance of IntInRangeValidator
     */
    public static IntInRangeValidator getIntInRangeValidator(int min, int max) {
        return new IntInRangeValidator(min, max);
    }
}
