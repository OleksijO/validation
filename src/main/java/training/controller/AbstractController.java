package training.controller;

import training.controller.validation.IntInRangeValidator;
import training.controller.validation.StringToPatternValidator;
import training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class AbstractController {
    public static final String SKIPPED_INPUT = "";

    private View view;

    public AbstractController(View view) {
        this.view = view;
    }

    // The Utility methods

    public int inputIntValueWithScanner(Scanner sc, String prompt) {
        view.printMessage(prompt);
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + prompt);
            sc.next();
        }
        return sc.nextInt();
    }

    public String inputStringValueWithScanner(Scanner sc, String prompt) {
        view.printMessage(prompt);
        return sc.nextLine();
    }

    public String inputStringValueWithValidation(Scanner scanner,
                                                 String prompt,
                                                 boolean allowEmptyInput,
                                                 StringToPatternValidator validator,
                                                 Pattern pattern) {
        while (true) {
            String userInput = inputStringValueWithScanner(scanner, prompt);
            if (allowEmptyInput &&
                    ((userInput == null) || (userInput.isEmpty()))) {
                return SKIPPED_INPUT;
            }
            userInput = userInput.replace("\n", "").replace("\r", "").trim();
            if (validator.validate(userInput, pattern)) {
                return userInput;
            }
            view.printMessage(validator.getErrorMessage() + View.TRY_AGAIN);
            validator.reset();
        }
    }

    public int inputIntValueWithScannerInRange(Scanner scanner, String prompt, IntInRangeValidator validator) {
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
