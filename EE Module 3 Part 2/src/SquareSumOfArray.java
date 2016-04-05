import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class SquareSumOfArray implements SquareSum {

    public static final int threadStartID = 9;

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        AtomicLong result = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        final int elementsPerThread;
        if (values.length / numberOfThreads == 0) {
            elementsPerThread = 1;
        } else {
            elementsPerThread = values.length / numberOfThreads;
        }
        int notCovered = values.length - elementsPerThread * numberOfThreads;
        Phaser phaser = new Phaser(numberOfThreads);
        Future[] f = new Future[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {

            f[i] = executor.submit(new Runnable() {
                @Override
                public void run() {
                    phaser.arriveAndAwaitAdvance();
                    if ((int) (Thread.currentThread().getId() - threadStartID) < values.length) {
                        for (int j = 0; j < elementsPerThread; j++) {
                            result.getAndAdd((long) Math.pow(values[(j + elementsPerThread * (int) (Thread.currentThread().getId() - threadStartID))], 2));
                        }
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if ((int) (Thread.currentThread().getId() - threadStartID + 1) == numberOfThreads && notCovered > 0) {
                        for (int j = 0; j < notCovered; j++) {
                            result.getAndAdd((long) Math.pow(values[(elementsPerThread + j + elementsPerThread * (int) (Thread.currentThread().getId() - threadStartID))], 2));
                        }

                    }
                }
            });

        }

        for (Future element : f) {
            try {
                element.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();


        return result.get();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 1, 1};
        SquareSumOfArray squareSumOfArray = new SquareSumOfArray();
        System.out.println("The result is: " + squareSumOfArray.getSquareSum(array, 4));
    }
}
