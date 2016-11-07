package training.view;

import training.view.notebook.AddressInputView;
import training.view.notebook.RecordInputView;

/**
 * This class is used as a factory of different views.
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class ViewFactory {
    /**
     * initializes and returns AddressInputView instance
     *
     * @return instance of AddressInputView
     */
    public static AddressInputView getAddressInputView(){
        return new AddressInputView();
    }

    /**
     * initializes and returns RecordInputView instance
     *
     * @return instance of RecordInputView
     */
    public static RecordInputView getRecordInputView(){
        return new RecordInputView();
    }

    /**
     * initializes and returns View instance
     *
     * @return instance of View
     */
    public static View getView(){
        return new View();
    }

}
