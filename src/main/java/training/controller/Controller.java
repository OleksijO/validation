package training.controller;

import training.model.Model;
import training.model.entity.notebook.Record;
import training.view.View;
import training.view.ViewFactory;

import java.util.Scanner;

/**
 * This class represents the main controller unit of MVC pattern program.
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class Controller extends AbstractController{

    /**
     * Reference to model unit
     */
    private Model model;
    /**
     * Reference to view unit
     */
    private View view;

    /**
     *  Initializes instance of class
     *
     * @param model the reference to model unit
     * @param view the reference to view unit
     */
    public Controller(Model model, View view) {
        super(view);
        this.model  = model;
        this.view = view;
    }

    /**
     * Runs the main program cycle. For now it inputs record of notebook and sends it to model for store
     */
    public void processUser(){
        Scanner scanner = new Scanner(System.in);
        Record record = ControllerFactory.getRecordInputController(ViewFactory.getRecordInputView())
                .inputRecordFromScanner(scanner);
        model.saveNotebookRecord(record);
    }

}
