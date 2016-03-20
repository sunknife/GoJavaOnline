import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Framework<T> implements Executor {
    Map<Task, Validator> tasks = new HashMap<>();
    boolean executionBegan = false;
    List<T> validResults = new ArrayList<>();
    List<T> invalidResults = new ArrayList<>();


    @Override
    public void addTask(Task task) throws ExecutionBeganException {
        if (executionBegan) throw new ExecutionBeganException();
        tasks.put(task, null);
    }

    @Override
    public void addTask(Task task, Validator validator) throws ExecutionBeganException {
        if (executionBegan) throw new ExecutionBeganException();
        tasks.put(task, validator);
    }

    @Override
    public void execute() {
        executionBegan = true;
        for (Map.Entry<Task, Validator> currentTask : tasks.entrySet()) {
            currentTask.getKey().execute();
            if (currentTask.getValue() != null) {
                if (currentTask.getValue().isValid(currentTask.getKey().getResult())) {
                    validResults.add((T)currentTask.getKey().getResult());
                } else {
                    invalidResults.add((T)currentTask.getKey().getResult());
                }
            } else {
                validResults.add((T)currentTask.getKey().getResult());
            }
        }
    }

    @Override
    public List getValidResults() throws ExecutionNotStartedException {
        if (!executionBegan) throw new ExecutionNotStartedException();
        return validResults;
    }

    @Override
    public List getInvalidResults() throws ExecutionNotStartedException {
        if (!executionBegan) throw new ExecutionNotStartedException();
        return invalidResults;
    }
}
