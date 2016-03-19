public class AgeValidator extends NumberValidator {

    @Override
    public boolean isValid(Object result) {
        if ((int)result > 120 || (int)result < 0) {
            return false;
        }
        return true;
    }
}

