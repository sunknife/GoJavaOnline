public class Substraction implements BinaryOperation{
    public boolean isUnary() {
        return false;
    }

    public double result(double left, double right) {
        return left-right;
    }
}
