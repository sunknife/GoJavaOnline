package FiguresArea;

public class IntegralCalculation {
    private double a;
    private double b;

    private double f(double x) {
        return x * x; //Here is your formula
    }

    public IntegralCalculation(double a, double b) {
        this.a = a;
        this.b = b;
    }


    public double monteCarloMethod(int accuracy) {
        // Accuracy should be positive. Can be replaced with method isPositive(int variable) to hide number
        if (!isPositive(accuracy)) {
            System.out.println("Accuracy value should be positive!");
            return 0;
        }
        double sum = 0.0;
        double step = (this.b - this.a) / accuracy;
        int counter = 0;
        for (double i = this.a + step; counter < accuracy; i += step, counter++) {
            sum += this.f(i);
        }
        return sum * step;
    }

    private boolean isPositive(int number) {
        return number > 0;
    }

    public static void main(String[] args) {
        IntegralCalculation anIntegral = new IntegralCalculation(0, 1);
        double result = anIntegral.monteCarloMethod(1000);
        System.out.println("Result is: " + result);
    }
}
