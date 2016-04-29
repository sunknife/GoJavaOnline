package calculatorLibrary;

public class Sum implements BinaryOperation{
    public double result(double left, double right) {
        return left+right;
    }

    public boolean isUnary() {
        return false;
    }
}
