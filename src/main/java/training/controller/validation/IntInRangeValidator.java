package training.controller.validation;

/**
 * This class provides functionality to check if int values are in bounds (included) of specified range
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public final class IntInRangeValidator extends AbstractValidator {
    public static final String INT_VALUE_IS_OUT_OF_RANGE = "Validation error. Value is out of bounds: min=%d, max=%d. ";
    private static final String WRONG_INT_RANGE_BOUNDS =
            "Error: the value of min range bound must be lower than or equals to max bound.";
    /**
     * Lower bound (included) of check range
     */
    private final int min;
    /**
     * Upper bound (included) of check range
     */
    private final int max;

    /**
     * Initializes instance of IntInRangeValidator
     *
     * @param min lower included bound of range
     * @param max upper included bound of range
     */
    public IntInRangeValidator(int min, int max) {
        if (max < min) {
            throw new RuntimeException(WRONG_INT_RANGE_BOUNDS);
        }
        this.min = min;
        this.max = max;
    }

    /**
     * Checks if the parameter is within specified range including bounds
     *
     * @param value the value to be checked
     * @return true if the value is within specified in validator constructor range including bounds,
     * false in other case
     */
    public boolean validate(int value) {
        if ((min <= value) && (value <= max)) {
            return true;
        }
        errorMessage = String.format(INT_VALUE_IS_OUT_OF_RANGE, min, max);
        return false;
    }


}
