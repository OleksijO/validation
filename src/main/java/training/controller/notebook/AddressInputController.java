package training.controller.notebook;

import training.controller.AbstractController;
import training.model.entity.notebook.Address;
import training.view.notebook.RecordInputView;

import java.util.Scanner;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class AddressInputController extends AbstractController {

    private RecordInputView view;

    public AddressInputController(RecordInputView view) {
        super(view);
        this.view = view;
    }

    public Address inputAddressFromScanner(Scanner scanner) {
        Address address = new Address();


        return address;
    }

    ;
}
