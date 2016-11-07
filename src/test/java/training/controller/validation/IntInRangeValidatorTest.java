package training.controller.validation;

import static org.junit.Assert.*;

/**
 * Created by oleksij.onysymchuk@gmail on 07.11.2016.
 */
public class IntInRangeValidatorTest {
    @org.junit.Test
    public void testValidate() throws Exception {
        int min=-100;
        int max = 100;
        IntInRangeValidator validator = new IntInRangeValidator(min,max);
        assertNull(validator.getErrorMessage());
        assertTrue(validator.validate(-100));
        assertNull(validator.getErrorMessage());
        assertTrue(validator.validate(100));
        assertNull(validator.getErrorMessage());
        assertTrue(validator.validate(0));
        assertNull(validator.getErrorMessage());
        assertFalse(validator.validate(max+1));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
        assertNull(validator.getErrorMessage());
        assertFalse(validator.validate(min-1));
        assertNotNull(validator.getErrorMessage());
        validator.reset();
        assertNull(validator.getErrorMessage());
    }

}