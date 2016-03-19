public class NumberValidator implements Validator {
    @Override
    public boolean isValid(Object result) {
        if (result instanceof Number) {
            return true;
        }
        return false;
    }
}
