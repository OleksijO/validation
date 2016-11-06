package training.view.notebook;

import training.view.View;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class RecordInputView extends View {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String MOBILE_PHONE_FORMAT = "+38(012)345-67-89";
    public static final String HOME_PHONE_FORMAT = "(012)345-67-89";
    public static final String INPUT_RECORD_DATA = "Input step by step record data.";
    public static final String INPUT_FIRST_NAME = "Input abonent's first name (min=1, max=30, only letters): ";
    public static final String INPUT_LAST_NAME = "Input abonent's last name (min=1, max=50, only letters and space): ";
    public static final String INPUT_MIDDLE_NAME = "Input abonent's middle name (min=1, max=30, only letters): ";
    public static final String INPUT_NICKNAME = "Input nickname (min=1, max=30, only latin letters, '_','-'): ";
    public static final String INPUT_COMMENT = "Input comment (min=1, max=255): ";
    public static final String GROUP_LIST = "Possible abonent's groups: ";
    public static final String INPUT_GROUP = "Input abonent's group number from list above (int value): ";
    public static final String INPUT_HOME_PHONE = "Input home phone number in format '" + HOME_PHONE_FORMAT + "': ";
    public static final String INPUT_MOBILE_PHONE = "Input mobile phone number in format '" +
            MOBILE_PHONE_FORMAT + "': ";
    public static final String INPUT_MOBILE_PHONE_2 = "Input second mobile phone number in format '" +
            MOBILE_PHONE_FORMAT + "' or press enter to skip: ";
    public static final String INPUT_EMAIL = "Input email (min=1, max=50): ";
    public static final String INPUT_SKYPE = "Input skype (min=1, max=50): ";
    public static final String INPUT_RECORD_CREATE_DATE = "Input date of record creation in format '" +
            DATE_FORMAT + "' or press enter to skip";
    public static final String INPUT_RECORD_LAST_MODIFIED_DATE = "Input date of last record modification in format '" +
            DATE_FORMAT + "' or press enter to skip";

}
