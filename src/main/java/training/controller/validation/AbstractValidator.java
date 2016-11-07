package training.controller.validation;

/**
 * This class includes common functionality for validators
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
abstract public class AbstractValidator {
    public static final String STRING_DO_NOT_MATHES_PATTERN = "Validation error: string do not matches pattern. ";
    /**
     * Stored validation error message if validation is failed
     */
    protected String errorMessage;

    /**
     * Removes error message to restore initial validator state
     */
    public void reset() {
        errorMessage = null;
    }

    /**
     * Returns validation error message
     *
     * @return Validation errror message
     */
    public String getErrorMessage() {
        return errorMessage;
    }
       
}
