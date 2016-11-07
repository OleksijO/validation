package training.view.notebook;

import training.view.View;

/**
 * This class extends common View and determines specific view constants for AddressInputController
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class AddressInputView extends View {
    public static final String INPUT_ADDRESS = "Input step by step address data.";
    public static final String INPUT_INDEX = "Input index (5 digits only with leading zeros): ";
    public static final String INPUT_CITY = "Input city(min=2, max=30, only letters)): ";
    public static final String INPUT_STREET = "Input street (min=2, max=30, " +
            "with identification 'str.', 'boul.', 'av.' etc.): ";
    public static final String INPUT_HOUSE_NUMBER = "Input house number (digits, letters, '-', '/'): ";
    public static final String INPUT_APARTMENT_NUMBER = "Input apartment number (digits, letters, '-', '/') " +
            "or press enter to skip:";
}
