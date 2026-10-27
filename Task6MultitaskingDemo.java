public class Task6MultitaskingDemo {

    // Task A: simulates downloading a file
    static class DownloadTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Downloading file: " + i + "/5");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("Download completed.");
        }
    }

    // Task B: simulates processing student records
    static class StudentProcessingTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Processing student record: " + i + "/5");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("Student processing completed.");
        }
    }

    public static void main(String[] args) {
        Thread download = new Thread(new DownloadTask());
        Thread processing = new Thread(new StudentProcessingTask());

        download.start();
        processing.start();
    }
}
