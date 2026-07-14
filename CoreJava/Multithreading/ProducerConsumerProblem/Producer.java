package CoreJava.Multithreading.ProducerConsumerProblem;



class Producer implements Runnable {
    SharedBuffer buffer;
    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run()
    {
       try {
            for(int i=1; i<=10; i++) {
                buffer.produceItem(i);
                System.out.println("Produced Item : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {Thread.currentThread().interrupt();}
    }

    
    
}
