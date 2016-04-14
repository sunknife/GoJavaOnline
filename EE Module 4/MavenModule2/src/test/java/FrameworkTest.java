import org.junit.Before;
import org.junit.Test;


public class FrameworkTest {
    Executor<Number> defaultExecutor;

    @Before
    public void setUp() throws Exception {
        defaultExecutor = new Framework<>();
    }

    @Test(expected = ExecutionBeganException.class)
    public void testAddTaskAfterExecution() throws Exception {
        defaultExecutor.execute();
        defaultExecutor.addTask(new CurrentAgeTask(1990));

    }

    @Test
    public void testAddTaskNoParameters() throws Exception {
        defaultExecutor.addTask(new CurrentAgeTask(1990));
    }

    @Test
    public void testExecuteAndGetResults() throws Exception {
        defaultExecutor.addTask(new CurrentAgeTask(1990));
        defaultExecutor.addTask(new CurrentAgeTask(2008), new NumberValidator());
        defaultExecutor.addTask(new CurrentAgeTask(1820), new AgeValidator());
        defaultExecutor.execute();
        System.out.println("Valid results:");
        for (Number task : defaultExecutor.getValidResults()) {
            System.out.println(task);
        }
        System.out.println("Invalid results:");
        for (Number task : defaultExecutor.getInvalidResults()) {
            System.out.println(task);
        }
    }

    @Test(expected = ExecutionNotStartedException.class)
    public void testGetValidResultsBeforeExecution() throws Exception {
        for (Number task : defaultExecutor.getValidResults()) {
            System.out.println(task);
        }
    }

    @Test(expected = ExecutionNotStartedException.class)
    public void testGetInvalidResultsBeforeExecution() throws Exception {
        for (Number task : defaultExecutor.getInvalidResults()) {
            System.out.println(task);
        }
    }
}