package CoreJava.Multithreading.ProducerConsumerProblem;

public class Consumer implements Runnable {
    SharedBuffer buffer;
     public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run()
    {
       try {
            for(int i=1; i<=10; i++) {
                Integer item = buffer.consumeItem();
                System.out.println("Consumed Item : " + item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {Thread.currentThread().interrupt();}
    
    }
}
