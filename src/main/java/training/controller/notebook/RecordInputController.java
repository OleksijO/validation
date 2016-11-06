package training.controller.notebook;

import training.controller.AbstractController;
import training.model.entity.notebook.Record;
import training.view.notebook.RecordInputView;

import java.util.Scanner;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class RecordInputController extends AbstractController {
    //patterns
    // «nick@mail.com»
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «http://www.my-site.com»
    public static final String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
    // «+38(044)555-55-55»
    public static final String REGEX_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private RecordInputView view;

    public RecordInputController(RecordInputView view) {
        super(view);
        this.view = view;
    }

    public Record inputRecordFromScanner(Scanner scanner){
        String stringValue;
        int intValue;
        Record record=new Record();



        return record;
    };
}
