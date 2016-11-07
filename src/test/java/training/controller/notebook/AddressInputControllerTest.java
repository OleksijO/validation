package training.controller.notebook;

import org.junit.Assert;
import org.junit.Test;
import training.model.entity.notebook.Address;
import training.view.ViewFactory;

import java.util.Scanner;

/**
 * Created by oleksij.onysymchuk@gmail on 07.11.2016.
 */
public class AddressInputControllerTest {
    @Test (timeout = 1000L)
    public void testInputAddressFromScanner() throws Exception {
        String index="12345";
        String city="City City -";
        String street="1-st Street, ave.";
        String house="45/1-D";
        String apartment="201-c";
        Address testAddress = new Address();
        testAddress.setIndex(index);
        testAddress.setCity(city);
        testAddress.setStreet(street);
        testAddress.setHouse(house);
        testAddress.setApartment(apartment);
        String input[] = {index, city, street, house, apartment};
        AddressInputController controller = new AddressInputController(ViewFactory.getAddressInputView()) {
            private int counter = 0;

            @Override
            public String inputStringValueWithScanner(Scanner scanner, String prompt) {
                System.out.println(input[counter]);
                return input[counter++];
            }
        };
        Address address = controller.inputAddressFromScanner(new Scanner(System.in));
        Assert.assertEquals(testAddress,address);
    }

}