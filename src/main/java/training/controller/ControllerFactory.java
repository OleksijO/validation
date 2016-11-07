package training.controller;

import training.controller.notebook.AddressInputController;
import training.controller.notebook.RecordInputController;
import training.model.Model;
import training.view.View;
import training.view.notebook.AddressInputView;
import training.view.notebook.RecordInputView;

/**
 * This class is used as a factory of different controllers.
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class ControllerFactory {

    /**
     * Inializes and returns instance of Controller.class
     *
     * @param model the reference to model unit
     * @param view the reference to view unit
     * @return instance of {@link Controller}
     */
    public static Controller getController(Model model, View view){
        return new Controller (model, view);
    }

    /**
     * Inializes and returns instance of RecordInputController.class
     *
     * @param view the reference to view unit
     * @return instance of {@link RecordInputController}
     */
    public static RecordInputController getRecordInputController(RecordInputView view){
        return new RecordInputController(view);
    }

    /**
     * Inializes and returns instance of AddressInputController.class
     *
     * @param view the reference to view unit
     * @return instance of {@link AddressInputController}
     */
    public static AddressInputController getAddressInputController(AddressInputView view){
        return new AddressInputController(view);
    }
}
