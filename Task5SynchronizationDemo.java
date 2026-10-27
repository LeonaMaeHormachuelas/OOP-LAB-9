public class Task5SynchronizationDemo {

    // Shared data object
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    // Worker thread that updates the shared counter
    static class CounterTask extends Thread {
        private final Counter counter;

        public CounterTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterTask thread1 = new CounterTask(counter);
        CounterTask thread2 = new CounterTask(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter: " + counter.getCount());
    }
}
