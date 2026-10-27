public class Task1ThreadDemo {

    // Thread created by extending the Thread class
    static class MessageThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Java Thread is Running - " + i);
            }
        }
    }

    // Main only creates objects and starts them
    public static void main(String[] args) {
        MessageThread thread = new MessageThread();
        thread.start();
        System.out.println("Main method continues.");
    }
}
