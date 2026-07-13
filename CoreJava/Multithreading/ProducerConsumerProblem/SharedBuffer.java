package CoreJava.Multithreading.ProducerConsumerProblem;

import java.util.List;
import java.util.Queue;

class SharedBuffer
{
    private final Queue<Integer> buffer;
    private final int bufferSize;
    SharedBuffer(Queue<Integer> list,int size)
    {
        buffer=list;
        this.bufferSize=size;
    }

    public synchronized void produceItem(Integer item) throws InterruptedException
    {
        while(buffer.size()==bufferSize)
            wait();
    
        buffer.offer(item);
        if(buffer.size()==1)
            notifyAll();
    }
    

    public synchronized Integer consumeItem() throws InterruptedException
    {
        Integer item = null;
        while(buffer.isEmpty())
            wait();
        
        item= buffer.poll();
        if(buffer.size()==(bufferSize-1))
            notifyAll();
        

        return item;
    }
    
}
