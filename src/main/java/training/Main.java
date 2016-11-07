package training;

import training.controller.Controller;
import training.controller.ControllerFactory;
import training.view.View;
import training.model.Model;
import training.view.ViewFactory;
/**
 * This class is used to initialize and run the program+
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = ViewFactory.getView();
        Controller controller = ControllerFactory.getController(model, view);
        // Run
        controller.processUser();
    }

}
