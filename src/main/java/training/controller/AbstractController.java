package training.controller;

import training.controller.validation.IntInRangeValidator;
import training.controller.validation.StringToPatternValidator;
import training.controller.validation.ValidatorFactory;
import training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class includes common functionality for controllers
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
abstract public class AbstractController {
    /**
     * Reference to the view, which is used to show messages
     */
    private View view;

    /**
     * Initializes fields of class
     *
     * @param view
     */
    public AbstractController(View view) {
        this.view = view;
    }

    /**
     * Prompts and inputs the only int user value
     *
     * @param scanner the reference to input source
     * @param prompt the text to ba shown as prompt
     * @return int value input by user
     */
    public int inputIntValueWithScanner(Scanner scanner, String prompt) {
        view.printMessage(prompt);
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Inputs user's string
     *
     * @param scanner the reference to input source
     * @param prompt the text to ba shown as prompt
     * @return string value input by user
     */
    public String inputStringValueWithScanner(Scanner scanner, String prompt) {
        view.printMessage(prompt);
        return scanner.nextLine();
    }

    /**
     * Inputs and matches to pattern user input string
     *
     * @param scanner the reference to input source
     * @param prompt the text to ba shown as prompt
     * @param pattern the compiled pattern value
     * @return string value input by user matched to pattern
     */
    public String inputStringValueWithValidation(Scanner scanner,
                                                 String prompt,
                                                 Pattern pattern) {
        StringToPatternValidator validator= ValidatorFactory.getStringToPatternValidator();
        while (true) {
            String userInput = inputStringValueWithScanner(scanner, prompt);
            userInput = userInput.replace("\n", "").replace("\r", "").trim();
            if (validator.validate(userInput, pattern)) {
                return userInput;
            }
            view.printMessage(validator.getErrorMessage() + View.TRY_AGAIN);
            validator.reset();
        }
    }

    /**
     * Inputs the only int value user input and checks if it is in specified range
     *
     * @param scanner the reference to input source
     * @param prompt the text to ba shown as prompt
     * @param min lower included bound of range
     * @param max upper included bound of range
     * @return int value in specified range input by user
     */
    public int inputIntValueWithScannerInRange(Scanner scanner, String prompt, int min, int max) {
        final IntInRangeValidator validator = ValidatorFactory.getIntInRangeValidator(min, max);
        while (true) {
            int value = inputIntValueWithScanner(scanner, prompt);
            if (validator.validate(value)) {
                return value;
            }
            view.printMessage(validator.getErrorMessage() + View.TRY_AGAIN);
            validator.reset();
        }
    }

}
