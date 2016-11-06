package training.view;

import training.view.notebook.AddressInputView;
import training.view.notebook.RecordInputView;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class ViewFactory {

    public static AddressInputView getAddressInputView(){
        return new AddressInputView();
    }

    public static RecordInputView getRecordInputView(){
        return new RecordInputView();
    }

    public static View getView(){
        return new View();
    }

}
