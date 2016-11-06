package training.controller.validation;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class AbstractValidator {
    public static final String STRING_DO_NOT_MATHES_PATTERN = "Validation error: string do not matches pattern. ";
    protected String errorMessage;

    public void reset() {
        errorMessage = null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
       
}
