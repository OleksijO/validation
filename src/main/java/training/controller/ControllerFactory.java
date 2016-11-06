package training.controller;

import training.controller.notebook.AddressInputController;
import training.controller.notebook.RecordInputController;
import training.view.notebook.AddressInputView;
import training.view.notebook.RecordInputView;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class ControllerFactory {

    public static RecordInputController getRecordInputController(RecordInputView view){
        return new RecordInputController(view);
    }

    public static AddressInputController getAddressInputController(AddressInputView view){
        return new AddressInputController(view);
    }
}
