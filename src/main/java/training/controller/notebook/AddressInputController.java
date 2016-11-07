package training.controller.notebook;

import training.controller.AbstractController;
import training.model.entity.notebook.Address;
import training.view.notebook.AddressInputView;

import java.util.Scanner;
import java.util.regex.Pattern;

import static training.view.notebook.AddressInputView.*;

/**
 * @author oleksij.onysymchuk@gmail
 * @version 7 NOV 2016
 */
public class AddressInputController extends AbstractController {
    /* Regexp for user inputs */
    private static final String REGEXP_INDEX = "[0-9]{5}";
    private static final String REGEXP_CITY = ".{2,30}";
    private static final String REGEXP_STREET = ".{2,30}";
    private static final String REGEXP_HOUSE = "^[\\d]+([\\/][\\d]+)?([-][А-Яа-яA-Za-z])?";
    private static final String REGEXP_APARTMENT = "(^[\\d]+([\\/][\\d]+)?([-][А-Яа-яA-Za-z])?)?";

    /* Compiled patterns for user inputs */
    public static final Pattern INDEX_PATTERN = Pattern.compile(REGEXP_INDEX);
    public static final Pattern CITY_PATTERN = Pattern.compile(REGEXP_CITY);
    public static final Pattern STREET_PATTERN = Pattern.compile(REGEXP_STREET);
    public static final Pattern HOUSE_PATTERN = Pattern.compile(REGEXP_HOUSE);
    public static final Pattern APARTMENT_PATTERN = Pattern.compile(REGEXP_APARTMENT);

    /**
     * The reference to view unit
     */
    private AddressInputView view;

    /**
     * Initializes class instance
     *
     * @param view the reference to view unit
     */
    public AddressInputController(AddressInputView view) {
        super(view);
        this.view = view;
    }

    /**
     * Inputs and validates fields of Address aux entity, returns it if ok.
     *
     * @param scanner the input source
     * @return The instance of aux entity Address, fullfilled with validated data
     */
    public Address inputAddressFromScanner(Scanner scanner) {
        Address address = new Address();
        String stringValue;

        view.printMessage(INPUT_ADDRESS);
        stringValue = inputStringValueWithValidation(scanner, INPUT_INDEX, INDEX_PATTERN);
        address.setIndex(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_CITY, CITY_PATTERN);
        address.setCity(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_STREET, STREET_PATTERN);
        address.setStreet(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_HOUSE_NUMBER, HOUSE_PATTERN);
        address.setHouse(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_APARTMENT_NUMBER, APARTMENT_PATTERN);
        address.setApartment(stringValue);

        return address;
    }

}
