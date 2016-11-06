package training.controller;

import training.model.Model;
import training.model.entity.notebook.Record;
import training.view.View;
import training.view.ViewFactory;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller extends AbstractController{

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        super(view);
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner scanner = new Scanner(System.in);
        Record record = ControllerFactory.getRecordInputController(ViewFactory.getRecordInputView())
                .inputRecordFromScanner(scanner);
        model.saveNotebookRecord(record);
        //inputIntValueWithScanner("",sc);
    }


}
