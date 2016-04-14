public class SemaphoreOrdinarius implements Semaphore {
    private volatile int  permitsNumber;
    private int permitsTotal;

    public SemaphoreOrdinarius(int permits) {
        permitsTotal = permits;
        permitsNumber = permitsTotal;
    }

    @Override
    public synchronized void  acquire() throws InterruptedException {
        if (this.getAvailablePermits() > 0) {
            permitsNumber--;
            System.out.println(Thread.currentThread().getName()+ "start working");
        } else {
            System.out.println(Thread.currentThread().getName()+ "waiting");
            while (this.getAvailablePermits() < 1) {
                this.wait();
            }
            permitsNumber--;
            System.out.println(Thread.currentThread().getName()+ "start working");
        }
    }

    @Override
    public synchronized void acquire(int permits) throws InterruptedException {
        if (permits <= this.getAvailablePermits()) {
            permitsNumber -= permits;
            System.out.println(Thread.currentThread().getName()+ "start working");
        } else {
            System.out.println(Thread.currentThread().getName()+ "waiting");
            while (this.getAvailablePermits() < permits) {
                this.wait();
            }
            permitsNumber -= permits;
            System.out.println(Thread.currentThread().getName()+ "start working");
        }
    }

    @Override
    public synchronized void release() {
        if (this.getAvailablePermits() < permitsTotal) {
            permitsNumber++;
            System.out.println(Thread.currentThread().getName()+ "stop working");
            this.notify();
        }
    }

    @Override
    public synchronized void release(int permits) {
        if (this.getAvailablePermits() + permits <= permitsTotal) {
            permitsNumber += permits;
            if (permits > 1) {
                this.notifyAll();
            } else  if (permits == 1) {
                this.notify();
            }
        }
    }

    @Override
    public synchronized int getAvailablePermits() {
        return permitsNumber;
    }

    public static void main(String[] args) {
        SemaphoreOrdinarius semaphore = new SemaphoreOrdinarius(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                    int i = 10;
                    while (i-- > 0) {
                        try {
                            semaphore.acquire();
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        semaphore.release();
                    }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    int j = 10;
                    while (j-- > 0) {
                        try {
                            semaphore.acquire();
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        semaphore.release();
                    }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    int k = 10;
                    while (k-- > 0) {
                        try {
                            semaphore.acquire();
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        semaphore.release();
                    }

            }
        }).start();

    }
}

