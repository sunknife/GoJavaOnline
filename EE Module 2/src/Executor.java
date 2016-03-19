import java.util.List;

public interface Executor<Object> {
    void addTask(Task<? extends Object> task) throws ExecutionBeganException;

    void addTask(Task<? extends Object> task, Validator <Object> validator) throws ExecutionBeganException;

    void execute();

    List<Object> getValidResults() throws ExecutionNotStartedException;

    List<Object> getInvalidResults() throws ExecutionNotStartedException;

}

