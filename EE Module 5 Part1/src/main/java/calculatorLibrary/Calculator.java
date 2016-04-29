package calculatorLibrary;

public interface Calculator {
    public void read(String expression);
    public void addOperation(Character character, Operation newOperation);
    public String getResult();
}
