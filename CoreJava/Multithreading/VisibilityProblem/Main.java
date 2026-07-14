package CoreJava.Multithreading.VisibilityProblem;

public class Main {

    public static void main(String[] args) {

        MyLock lock = new MyLock();

        Thread worker = new Thread(() -> {

            System.out.println("Worker: Waiting for unlock...");

            while (lock.isLocked()) {
                System.out.println("Worker sees locked = true");
            }

            System.out.println("Worker: Lock released, continuing work.");

        }, "worker-1");


        Thread releaser = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Releaser: Unlocking...");
            lock.unlock();

        }, "worker-2");


        worker.start();
        releaser.start();


        try {
            worker.join();
            releaser.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}