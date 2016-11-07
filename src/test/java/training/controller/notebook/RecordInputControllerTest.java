package training.controller.notebook;

import org.junit.Assert;
import org.junit.Test;
import training.model.entity.notebook.Address;
import training.model.entity.notebook.Group;
import training.model.entity.notebook.Record;
import training.view.ViewFactory;
import training.view.notebook.AddressInputView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by oleksij.onysymchuk@gmail on 07.11.2016.
 */
public class RecordInputControllerTest {
    @Test
    public void testInputRecordFromScanner() throws Exception {
        String index = "12345";
        String city = "City City -";
        String street = "1-st Street, ave.";
        String house = "45/1-D";
        String apartment = "201-c";
        Address testAddress = new Address();
        testAddress.setIndex(index);
        testAddress.setCity(city);
        testAddress.setStreet(street);
        testAddress.setHouse(house);
        testAddress.setApartment(apartment);
        String lastName = "Surname-Surname";
        String firstName = "Firstname";
        String middleName = "Middlename";
        String lastNameAndInitials = "Surname-Surname F.";
        String nickName = "nick_Name-23";
        String comment = "comment";
        Group group = Group.values()[1];
        String homePhone = "(000)000-00-00";
        String mobilePhone = "+38(000)000-00-00";
        String mobilePhone2 = "+38(000)000-00-00";
        String email = "email@email.com";
        String skype = "skype.login00";
        String fullAddress = testAddress.getFullAddress();
        Date creationDate = new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2015");
        Date lastModifiedDate = new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2015");
        Record testRecord = new Record();
        testRecord.setLastName(lastName);
        testRecord.setFirstName(firstName);
        testRecord.setMiddleName(middleName);
        testRecord.setLastNameAndInitials(lastNameAndInitials);
        testRecord.setNickName(nickName);
        testRecord.setComment(comment);
        testRecord.setGroup(group);
        testRecord.setHomePhone(homePhone);
        testRecord.setMobilePhone(mobilePhone);
        testRecord.setMobilePhone2(mobilePhone2);
        testRecord.setEmail(email);
        testRecord.setSkype(skype);
        testRecord.setAddress(testAddress);
        testRecord.setFullAddress(fullAddress);
        testRecord.setCreationDate(creationDate);
        testRecord.setLastModifiedDate(lastModifiedDate);

        String input[] = {lastName, firstName, middleName, nickName, comment,
                homePhone, mobilePhone, mobilePhone2, email, skype, "10/10/2015", "11/11/2015"};
        RecordInputController controller = new RecordInputController(ViewFactory.getRecordInputView()) {
            private int counter = 0;

            @Override
            public String inputStringValueWithScanner(Scanner scanner, String prompt) {
                System.out.println(input[counter]);
                return input[counter++];
            }

            @Override
            public int inputIntValueWithScannerInRange(Scanner scanner, String prompt, int min, int max) {
                return 1;
            }

            @Override
            protected AddressInputController getAddressInputController(AddressInputView view) {
                return new AddressInputController(ViewFactory.getAddressInputView()) {
                    @Override
                    public Address inputAddressFromScanner(Scanner scanner) {
                        return testAddress;
                    }
                };
            }
        };
        Record record = controller.inputRecordFromScanner(new Scanner(System.in));
        Assert.assertEquals(testRecord, record);

    }

}