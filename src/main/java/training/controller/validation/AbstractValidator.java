package training.controller.validation;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class AbstractValidator {
    public static final String STRING_DO_NOT_MATHES_PATTERN = "Validation error: string do not matches pattern.";
    public static final String WRONG_INT_RANGE_BOUNDS = "Range Bounds error: max must be more than or equals to max!";
    protected String errorMessage;

    public void reset() {
        errorMessage = null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
       
}
