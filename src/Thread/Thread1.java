package Thread;

import java.util.Queue;

public class Thread1 implements Runnable {

    Queue<Integer> queue;

    public Thread1(Queue<Integer> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (queue)
            {
                if(queue.size() == 0)
                {
                    break;
                }

                if(queue.peek() % 2 == 1)
                {
                    System.out.println("Thread 1 poll a Number : " + queue.poll());
                }
            }
        }
    }
}
