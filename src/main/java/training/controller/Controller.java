package training.controller;

import training.model.Model;
import training.view.View;

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
        Scanner sc = new Scanner(System.in);

       //inputIntValueWithScanner("",sc);
    }


}
