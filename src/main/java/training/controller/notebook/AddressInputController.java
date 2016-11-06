package training.controller.notebook;

import training.controller.AbstractController;
import training.controller.validation.StringToPatternValidator;
import training.controller.validation.ValidatorFactory;
import training.model.entity.notebook.Address;
import training.view.notebook.AddressInputView;

import java.util.Scanner;
import java.util.regex.Pattern;

import static training.view.notebook.AddressInputView.*;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class AddressInputController extends AbstractController {
    private static final String REGEXP_INDEX = "[0-9]{5}";
    private static final String REGEXP_CITY = ".{2,30}";
    private static final String REGEXP_STREET = ".{2,30}";
    private static final String REGEXP_HOUSE = "^[\\d]+([\\/][\\d]+)?([-][А-Яа-яA-Za-z])?";
    private static final String REGEXP_APARTMENT = "^[\\d]+([\\/][\\d]+)?([-][А-Яа-яA-Za-z])?";

    public static final Pattern INDEX_PATTERN = Pattern.compile(REGEXP_INDEX);
    public static final Pattern CITY_PATTERN = Pattern.compile(REGEXP_CITY);
    public static final Pattern STREET_PATTERN = Pattern.compile(REGEXP_STREET);
    public static final Pattern HOUSE_PATTERN = Pattern.compile(REGEXP_HOUSE);
    public static final Pattern APARTMENT_PATTERN = Pattern.compile(REGEXP_APARTMENT);

    private AddressInputView view;

    public AddressInputController(AddressInputView view) {
        super(view);
        this.view = view;
    }

    public Address inputAddressFromScanner(Scanner scanner) {
        Address address = new Address();
        String stringValue;
        StringToPatternValidator stringValidator = ValidatorFactory.getStringToPatternValidator();

        view.printMessage(INPUT_ADDRESS);
        stringValue = inputStringValueWithValidation(scanner, INPUT_INDEX, false, stringValidator, INDEX_PATTERN);
        address.setIndex(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_CITY, false, stringValidator, CITY_PATTERN);
        address.setCity(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_STREET, false, stringValidator, STREET_PATTERN);
        address.setStreet(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_HOUSE_NUMBER, false, stringValidator,
                HOUSE_PATTERN);
        address.setHouse(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_APARTMENT_NUMBER, false, stringValidator,
                APARTMENT_PATTERN);
        address.setApartment(stringValue);

        return address;
    }

}
