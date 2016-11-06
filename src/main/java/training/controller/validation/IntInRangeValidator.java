package training.controller.validation;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public final class IntInRangeValidator extends AbstractValidator {
    public static final String INT_VALUE_IS_OUT_OF_RANGE = "Validation error. Value is out of bounds: min=%d, max=%d. ";
    private static final String WRONG_INT_RANGE_BOUNDS =
            "Error: the value of min range bound must be lower than or equals to max bound.";
    private final int min;
    private final int max;

    public IntInRangeValidator(int min, int max) {
        if (max < min) {
            throw new RuntimeException(WRONG_INT_RANGE_BOUNDS);
        }
        this.min = min;
        this.max = max;
    }

    public boolean validate(int value) {
        if ((min <= value) && (value <= max)) {
            return true;
        }
        errorMessage = String.format(INT_VALUE_IS_OUT_OF_RANGE, min, max);
        return false;
    }


}
