package CoreJava.Multithreading.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
         Queue<Integer> queue = new LinkedList<>();

        SharedBuffer buffer = new SharedBuffer(queue, 2);

        Thread producerThread = new Thread(new Producer(buffer), "Producer");

        Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");

        producerThread.start();
        consumerThread.start();
    }
    
}
