package training.controller.validation;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by oleksij.onysymchuk@gmail on 07.11.2016.
 */
public class StringToPatternValidatorTest {
    @Test
    public void testValidate() throws Exception {
        StringToPatternValidator validator = new StringToPatternValidator();
        Pattern pattern = Pattern.compile(".{2,3}");
        assertNull(validator.getErrorMessage());
        assertTrue(validator.validate("12",pattern));
        assertNull(validator.getErrorMessage());
        assertTrue(validator.validate("123",pattern));
        assertNull(validator.getErrorMessage());
        assertFalse(validator.validate("",pattern));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
        assertNull(validator.getErrorMessage());
        assertFalse(validator.validate("1234",pattern));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
        assertNull(validator.getErrorMessage());
        assertFalse(validator.validate(null,pattern));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
        assertFalse(validator.validate("12",null));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
    }

}