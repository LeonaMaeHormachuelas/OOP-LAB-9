public class Task4PriorityDemo {

    static class PriorityTask extends Thread {
        public PriorityTask(String name, int priority) {
            super(name);
            setPriority(priority);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                    getName() + " | Priority: " + getPriority() + " | Count: " + i
                );
            }
        }
    }

    public static void main(String[] args) {
        PriorityTask low = new PriorityTask("LowPriorityThread", Thread.MIN_PRIORITY);
        PriorityTask high = new PriorityTask("HighPriorityThread", Thread.MAX_PRIORITY);

        low.start();
        high.start();
    }
}
