package training.view;

/**
 * Thisa class represents common view functionality
 *
 * @version 7 NOV 2016
 * @author oleksij.onysymchuk@gmail
 */
public class View {

    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String TRY_AGAIN = "Repeat with more attention, please! ";

    /**
     * shows message on standart out
     *
     * @param message a text to be shown on standart out
     */
    public void printMessage(String message){
        System.out.println(message);
    }

}
