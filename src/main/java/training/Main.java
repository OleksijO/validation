package training;

import training.controller.Controller;
import training.view.View;
import training.model.Model;
import training.view.ViewFactory;

public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = ViewFactory.getView();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}
