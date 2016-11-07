package training.controller.notebook;

import training.controller.AbstractController;
import training.controller.ControllerFactory;
import training.model.entity.notebook.Address;
import training.model.entity.notebook.Group;
import training.model.entity.notebook.Record;
import training.view.ViewFactory;
import training.view.notebook.AddressInputView;
import training.view.notebook.RecordInputView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import static training.view.notebook.RecordInputView.*;

/**
 * @author oleksij.onysymchuk@gmail
 * @version 7 NOV 2016
 */
public class RecordInputController extends AbstractController {
    /* Date parsing error message */
    private static final String DATE_PARSING_ERROR = "ERROR! Unexpected situation while parsing dates. Aborting...";

    /* Regexp for user inputs */
    private static final String REGEX_FIRST_NAME = "^[A-ZА-Яa-zа-я\\-]{1,30}";
    private static final String REGEX_LAST_NAME = "^[A-ZА-Я]([a-zа-я-\\s]{1,49})?";
    private static final String REGEX_MIDDLE_NAME = "^[A-ZА-Я]([a-zа-я\\-]{1,29})?";
    private static final String REGEX_NICKNAME = "^[A-Za-z]([A-Za-z0-9_-]{1,29})?";
    private static final String REGEX_COMMENT = ".{1,255}";
    private static final String REGEX_HOME_PHONE = "^\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String REGEX_MOBILE_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String REGEX_MOBILE_PHONE_2 = "(^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$)?";
    private static final String REGEX_EMAIL =
            "^([a-z0-9_-]+\\.)*[a-z0-9_\\-]+@[a-z0-9_-]+(\\.[a-z0-9_\\-]+)*\\.[a-z]{2,6}$";
    private static final String REGEX_SKYPE = "^[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}$";
    private static final String REGEX_RECORD_DATE = "^\\d{2}/\\d{2}/\\d{4}$";

    /* Patterns for output strings */
    private static final String LAST_NAME_AND_INITIALS_FORMAT = "%s %s.";
    private static final String ROW_FORMAT_GROUP_LIST = "%d\t%s";

    /* Compiled patterns for user inputs */
    public static final Pattern PATTERN_FIRST_NAME = Pattern.compile(REGEX_FIRST_NAME);
    public static final Pattern PATTERN_LAST_NAME = Pattern.compile(REGEX_LAST_NAME);
    public static final Pattern PATTERN_MIDDLE_NAME = Pattern.compile(REGEX_MIDDLE_NAME);
    public static final Pattern PATTERN_NICKNAME = Pattern.compile(REGEX_NICKNAME);
    public static final Pattern PATTERN_COMMENT = Pattern.compile(REGEX_COMMENT);
    public static final Pattern PATTERN_HOME_PHONE = Pattern.compile(REGEX_HOME_PHONE);
    public static final Pattern PATTERN_MOBILE_PHONE = Pattern.compile(REGEX_MOBILE_PHONE);
    public static final Pattern PATTERN_MOBILE_PHONE_2 = Pattern.compile(REGEX_MOBILE_PHONE_2);
    public static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern PATTERN_SKYPE = Pattern.compile(REGEX_SKYPE);
    public static final Pattern PATTERN_RECORD_DATE = Pattern.compile(REGEX_RECORD_DATE);

    /**
     * The reference to view unit
     */
    private RecordInputView view;

    /**
     * Initializes class instance
     *
     * @param view the reference to view unit
     */
    public RecordInputController(RecordInputView view) {
        super(view);
        this.view = view;
    }

    /**
     * Inputs and validates fields of Record entity, returns it if ok.
     *
     * @param scanner the input source
     * @return The instance of entity Record, fullfilled with validated data
     */
    public Record inputRecordFromScanner(Scanner scanner) {
        Record record = new Record();

        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String stringValue;
        int intValue;
        view.printMessage(INPUT_RECORD_DATA);
        stringValue = inputStringValueWithValidation(scanner, INPUT_LAST_NAME, PATTERN_FIRST_NAME);
        record.setLastName(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_FIRST_NAME, PATTERN_LAST_NAME);
        record.setFirstName(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_MIDDLE_NAME, PATTERN_MIDDLE_NAME);
        record.setMiddleName(stringValue);
        record.setLastNameAndInitials(
                String.format(
                        LAST_NAME_AND_INITIALS_FORMAT, record.getLastName(), record.getFirstName().substring(0, 1)));
        stringValue = inputStringValueWithValidation(scanner, INPUT_NICKNAME, PATTERN_NICKNAME);
        record.setNickName(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_COMMENT, PATTERN_COMMENT);
        record.setComment(stringValue);
        printGroups();
        intValue = inputIntValueWithScannerInRange(scanner, INPUT_GROUP, 0, Group.values().length - 1);
        record.setGroup(Group.values()[intValue]);
        stringValue = inputStringValueWithValidation(scanner, INPUT_HOME_PHONE, PATTERN_HOME_PHONE);
        record.setHomePhone(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_MOBILE_PHONE, PATTERN_MOBILE_PHONE);
        record.setMobilePhone(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_MOBILE_PHONE_2, PATTERN_MOBILE_PHONE_2);
        record.setMobilePhone2(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_EMAIL, PATTERN_EMAIL);
        record.setEmail(stringValue);
        stringValue = inputStringValueWithValidation(scanner, INPUT_SKYPE, PATTERN_SKYPE);
        record.setSkype(stringValue);
        Address address = getAddressInputController(ViewFactory.getAddressInputView())
                .inputAddressFromScanner(scanner);
        record.setAddress(address);
        record.setFullAddress(address.getFullAddress());

        try {
            while (true) {
                stringValue = inputStringValueWithValidation(scanner, INPUT_RECORD_CREATE_DATE, PATTERN_RECORD_DATE);
                if ((stringValue == null) || (stringValue.isEmpty())) {
                    record.setCreationDate(sdf.parse(sdf.format(new Date())));
                } else {
                    record.setCreationDate(sdf.parse(stringValue));
                }

                stringValue =
                        inputStringValueWithValidation(scanner, INPUT_RECORD_LAST_MODIFIED_DATE, PATTERN_RECORD_DATE);
                if ((stringValue == null) || (stringValue.isEmpty())) {
                    Date lastModified = sdf.parse(stringValue);
                    if (lastModified.compareTo(record.getCreationDate()) < 0) {
                        view.printMessage(REINPUT_DATES);
                        continue;
                    }
                    record.setLastModifiedDate(sdf.parse(sdf.format(new Date())));
                } else {
                    record.setLastModifiedDate(sdf.parse(stringValue));
                }
                break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(DATE_PARSING_ERROR);
        }
        return record;
    }

    private void printGroups() {
        for (Group group : Group.values()) {
            view.printMessage(String.format(ROW_FORMAT_GROUP_LIST, group.ordinal(), group.toString()));
        }
    }

    protected AddressInputController getAddressInputController(AddressInputView view){
        return ControllerFactory.getAddressInputController(view);
    }

}
