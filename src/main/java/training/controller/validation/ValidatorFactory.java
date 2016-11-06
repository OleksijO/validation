package training.controller.validation;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class ValidatorFactory {

    public static StringToPatternValidator getStringToPatternValidator(){
        return new StringToPatternValidator();
    }

    public static IntInRangeValidator getIntInRangeValidator(int min, int max){
        return new IntInRangeValidator(min,max);
    }
}
