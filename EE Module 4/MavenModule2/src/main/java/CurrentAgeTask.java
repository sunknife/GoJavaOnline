public class CurrentAgeTask implements Task {
    private final Integer CURRENT_YEAR = 2016;
    int age;
    int birthAge;
    public CurrentAgeTask(Integer inputAge) {
        birthAge = inputAge;
    }
    @Override
    public void execute() {
        age = CURRENT_YEAR - birthAge;
    }

    @Override
    public Integer getResult() {
        return age;
    }
}

