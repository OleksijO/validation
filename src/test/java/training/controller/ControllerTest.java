package training.controller;

import org.junit.Test;
import training.model.Model;
import training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * This test class is using for test controller unit
 *
 * @author oleksij.onysymchuk@gmail
 */
public class ControllerTest {


    @Test
    public void testInputIntValueWithScannerInRange() {
        Model model = new Model();
        View view = new View();
        int input[] = {40,60,50};
        Scanner scanner = new Scanner(System.in);
        // replacing user input to strings from array
        Controller controller = new Controller(model, view) {
            private int counter = 0;

            @Override
            public int inputIntValueWithScanner(Scanner scanner, String prompt) {
                System.out.println(input[counter]);
                return input[counter++];
            }
        };
        int value = controller.inputIntValueWithScannerInRange(scanner, "", 45, 55);
        assertEquals(50, value);
    }

    @Test
    public void testInputStringValueWithValidation() {
        Model model = new Model();
        View view = new View();
        Pattern pattern = Pattern.compile("(.){2,3}]");
        String input[] = {"1", "1234", "  ", "    ", "215234523454323423", "50"};
        Scanner scanner = new Scanner(System.in);
        // replacing user input to strings from array
        Controller controller = new Controller(model, view) {
            private int counter = 0;

            @Override
            public String inputStringValueWithScanner(Scanner scanner, String prompt) {
                System.out.println(input[counter]);
                return input[counter++];
            }
        };
        String value = controller.inputStringValueWithValidation(scanner, "", pattern);
        assertEquals("50", value);
    }


}
