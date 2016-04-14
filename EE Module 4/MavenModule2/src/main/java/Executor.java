import java.util.List;

public interface Executor<T> {
    void addTask(Task<? extends T> task) throws ExecutionBeganException;

    void addTask(Task<? extends T> task, Validator <? super T> validator) throws ExecutionBeganException;

    void execute();

    List<T> getValidResults() throws ExecutionNotStartedException;

    List<T> getInvalidResults() throws ExecutionNotStartedException;

}

