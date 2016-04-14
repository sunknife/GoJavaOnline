public class TemperatureTask implements Task {
    double temperature;
    public TemperatureTask(Double input) {
        temperature = input;
    }
    @Override
    public void execute() {

    }

    @Override
    public Object getResult() {
        return temperature;
    }
}
